package com.wisn.web;


import com.wisn.entity.User;
import com.wisn.exception.*;
import com.wisn.http.HttpResponse;
import com.wisn.http.bean.ChangePassword;
import com.wisn.protocol.session.TokenEntity;
import com.wisn.protocol.session.TokenManager;
import com.wisn.service.UserService;
import com.wisn.tools.Base64Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/userdata")
public class UserDataController {

    @Autowired
    private UserService userService;


    @ResponseBody
    @RequestMapping(value = "/getusers", method = RequestMethod.GET)
    public HttpResponse<List<User>> getAllUser(int offset, int limit) {
        HttpResponse<List<User>> response ;
        List<User> users = null;
        try {
            users = userService.getUsers(offset, limit);
            response = new HttpResponse<>(200, "获取成功");
            response.data = users;
        } catch (Exception e) {
            e.printStackTrace();
            response = new HttpResponse<>(500, e.getMessage());
        }
        return response;
    }

    @ResponseBody
    @RequestMapping(value = "/changpassword", method = RequestMethod.PUT)
//    public HttpResponse<String> changPassword(@RequestHeader(value = "Authorization") String Authorization, @RequestParam(value="oldPassword",required=true) String oldPassword,@RequestParam(value="newPassword",required=true) String newPassword) {
    public HttpResponse<String> changPassword(@RequestHeader(value = "Authorization") String Authorization,
                                            @RequestBody ChangePassword changePassword) {
        System.out.println("Authorization:"+Authorization+" old:"+changePassword.oldPassword+" new:"+changePassword.newPassword);
        HttpResponse<String> response = null;
        try {
            TokenEntity tokenEntity = TokenManager.getToken(Authorization);
            Long userid = tokenEntity.getUserid();
            boolean updatePasswordSuccess = userService.updatePassword(userid, changePassword.oldPassword, changePassword.newPassword);
            if(!updatePasswordSuccess){
                throw new OperationException("操作失败");
            }
            response = new HttpResponse<>(200, "修改密码成功");
        } catch (OperationException e) {
            response = new HttpResponse<>(500, e.getMessage());
        } catch (ParameterException e) {
            response = new HttpResponse<>(400, e.getMessage());
        } catch (NoAuthException e) {
            response = new HttpResponse<>(403, e.getMessage());
        } catch (UnRegisteredException e) {
            response = new HttpResponse<>(401, e.getMessage());
        }catch (Exception e){
            response = new HttpResponse<>(500, e.getMessage());
        }
        return response;
    }

    @ResponseBody
    @RequestMapping(value = "/aaaaaaa", method = RequestMethod.GET)
    public HttpResponse<List<User>> changPassword(@RequestHeader HttpHeaders headers, String oldPassword, String newPassword) {
//        List<User> users = userService.getUsers(offset, limit);
//        System.out.println(" data:" + users);
//        HttpResponse<List<User>> response = new HttpResponse<>();
//        response.code = 200;
//        response.message = "success";
//        response.data = users;
//        return response;
        return null;
    }

    @ResponseBody
    @RequestMapping(value = "/uploadicon", method = RequestMethod.POST)
    public HttpResponse<String> upload(HttpServletRequest req, String checkLocationInfoJson) throws Exception {
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String s = headerNames.nextElement();
            System.out.println("header:" + s + " value:" + req.getHeader(s));
        }
        byte[] decode = Base64Utils.decode(checkLocationInfoJson);
        System.out.println("checkLocationInfoJson:" + new String(decode));
        String path = req.getSession().getServletContext().getRealPath("/") +
                "upload/";
        File tempfile = new File(path);
        if (!tempfile.exists()) {
            tempfile.mkdirs();
        }
        MultipartHttpServletRequest mreq = (MultipartHttpServletRequest) req;
        Map<String, MultipartFile> fileMap = mreq.getFileMap();
        Iterator<Map.Entry<String, MultipartFile>> iterator = fileMap.entrySet().iterator();
        int i = 0;
        while (iterator.hasNext()) {
            i++;
            Map.Entry<String, MultipartFile> next = iterator.next();
            String key = next.getKey();
            MultipartFile file = next.getValue();
            System.out.println("file:" + key + " i:" + i);
            String fileName = file.getOriginalFilename();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            FileOutputStream fos = new FileOutputStream(path + key + "_" + sdf.format(new Date()) + i + fileName.substring(fileName.lastIndexOf('.')));
            fos.write(file.getBytes());
            fos.flush();
            fos.close();
        }
        HttpResponse<String> stringHttpResponse = new HttpResponse<>(200, "上传成功");
        stringHttpResponse.data = null;
        return stringHttpResponse;
    }
}

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
import java.io.IOException;
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
        HttpResponse<List<User>> response;
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
    public HttpResponse<String> changPassword(@RequestHeader(value = "Authorization") String Authorization,
                                              @RequestBody ChangePassword changePassword) {
        System.out.println("Authorization:" + Authorization + " old:" + changePassword.oldPassword + " new:" + changePassword.newPassword);
        HttpResponse<String> response = null;
        try {
            TokenEntity tokenEntity = TokenManager.getToken(Authorization);
            Long userid = tokenEntity.getUserid();
            boolean updatePasswordSuccess = userService.updatePassword(userid, changePassword.oldPassword, changePassword.newPassword);
            if (!updatePasswordSuccess) {
                throw new OperationException("操作失败");
            }
            TokenManager.removeToken(Authorization);
            response = new HttpResponse<>(200, "修改密码成功");
        } catch (OperationException e) {
            response = new HttpResponse<>(500, e.getMessage());
        } catch (ParameterException e) {
            response = new HttpResponse<>(400, e.getMessage());
        } catch (NoAuthException e) {
            response = new HttpResponse<>(403, e.getMessage());
        } catch (UnRegisteredException e) {
            response = new HttpResponse<>(401, e.getMessage());
        } catch (Exception e) {
            response = new HttpResponse<>(500, e.getMessage());
        }
        return response;
    }


    @ResponseBody
    @RequestMapping(value = "/uploadicon", method = RequestMethod.POST)
    public HttpResponse<String> upload(@RequestHeader(value = "Authorization") String Authorization, HttpServletRequest req) throws Exception {
        HttpResponse<String> stringHttpResponse = null;
        try {
            TokenEntity tokenEntity = TokenManager.getToken(Authorization);
            Long userid = tokenEntity.getUserid();
            String path = req.getSession().getServletContext().getRealPath("/") +
                    "icon/";
            MultipartHttpServletRequest mreq = (MultipartHttpServletRequest) req;
            MultipartFile icon = mreq.getFile("icon");
            if (icon == null) {
                throw new ParameterException("数据错误");
            }
            String originalFilename = icon.getOriginalFilename();
            File tempfile = new File(path);
            if (!tempfile.exists()) {
                tempfile.mkdirs();
            }
            String fileType = originalFilename.substring(originalFilename.lastIndexOf('.'));
            if ("jpeg".equalsIgnoreCase(fileType) || "png".equalsIgnoreCase(fileType) || "jpg".equalsIgnoreCase(fileType)) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
                String reallyFilename = sdf.format(new Date()) + UUID.randomUUID() + fileType;
                FileOutputStream fos = new FileOutputStream(path + reallyFilename);
                fos.write(icon.getBytes());
                fos.flush();
                fos.close();
                User user = new User();
                user.setUserid(userid);
                user.setIconurl("/icon/" + reallyFilename);
                boolean updateIconSuccess = userService.updateIcon(user);
                if (updateIconSuccess) {
                    stringHttpResponse = new HttpResponse<>(200, "上传成功");
                    stringHttpResponse.data = "/icon/" + reallyFilename;
                    return stringHttpResponse;
                }
                throw new OperationException("操作失败");
            }
            throw new ParameterException("数据错误");
        } catch (ParameterException e) {
            e.printStackTrace();
            stringHttpResponse = new HttpResponse<>(400, e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            stringHttpResponse = new HttpResponse<>(500, e.getMessage());
        }
        return stringHttpResponse;
    }


    @ResponseBody
    @RequestMapping(value = "/aaaaaaa", method = RequestMethod.GET)
    public HttpResponse<List<User>> changPassword(@RequestHeader HttpHeaders headers, String oldPassword, String newPassword) {
        return null;
    }

    @ResponseBody
    @RequestMapping(value = "/uploadiconbackup", method = RequestMethod.POST)
    public HttpResponse<String> upload(HttpServletRequest req, String testparams) throws Exception {
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String s = headerNames.nextElement();
            System.out.println("header:" + s + " value:" + req.getHeader(s));
        }
        byte[] decode = Base64Utils.decode(testparams);
        System.out.println("checkLocationInfoJson:" + new String(decode));
        String path = req.getSession().getServletContext().getRealPath("/") +
                "upload/";
        File tempfile = new File(path);
        if (!tempfile.exists()) {
            tempfile.mkdirs();
        }
        MultipartHttpServletRequest mreq = (MultipartHttpServletRequest) req;
        Iterator<String> fileNames = mreq.getFileNames();
        int i = 0;
        while (fileNames.hasNext()) {
            String next = fileNames.next();
            List<MultipartFile> files = mreq.getFiles(next);
            for (MultipartFile file : files) {
                i++;
                long size = file.getSize();
                String fileName = file.getOriginalFilename();
                System.out.println("file:" + next + " i:" + i + " fileName:" + fileName + " fileSize:" + size);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
                FileOutputStream fos = new FileOutputStream(path + next + "_" + sdf.format(new Date()) + i + fileName.substring(fileName.lastIndexOf('.')));
                fos.write(file.getBytes());
                fos.flush();
                fos.close();
            }
        }
        HttpResponse<String> stringHttpResponse = new HttpResponse<>(200, "上传成功");
        stringHttpResponse.data = null;
        return stringHttpResponse;
    }
}

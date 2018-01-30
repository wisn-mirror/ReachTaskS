package com.wisn.web;


import com.wisn.entity.User;
import com.wisn.exception.NoAuthException;
import com.wisn.exception.OperationException;
import com.wisn.exception.ParameterException;
import com.wisn.exception.UnRegisteredException;
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
@RequestMapping("/moment")
public class UserMomentController {

    @Autowired
    private UserService userService;


    @ResponseBody
    @RequestMapping(value = "/sendment", method = RequestMethod.POST)
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

}

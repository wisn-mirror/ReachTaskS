package com.wisn.web;


import com.wisn.exception.*;
import com.wisn.http.HttpResponse;
import com.wisn.entity.User;
import com.wisn.protocol.session.TokenEntity;
import com.wisn.protocol.session.TokenManager;
import com.wisn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public HttpResponse<String> register(@RequestBody User user) {
        HttpResponse<String> response = null;
        try {
            boolean register = userService.register(user);
            if (register) {
                response = new HttpResponse<>(200, "注册成功");
            } else {
                response = new HttpResponse<>(403, "注册失败");
            }
        } catch (ParameterException e) {
            response = new HttpResponse<>(400, e.getMessage());
        } catch (AlreadyRegisteredException e) {
            response = new HttpResponse<>(403, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            response = new HttpResponse<>(500, e.getMessage());
        }
        return response;
    }

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public HttpResponse<User> login(@RequestBody User user) {
        HttpResponse<User> response = null;
        try {
            User login = userService.login(user.getPhonenumber(), user.getPassword());
            response = new HttpResponse<>(200, "登录成功");
            response.data = login;
            return response;
        } catch (ParameterException e) {
            response = new HttpResponse<>(400, "参数错误");
        } catch (UnRegisteredException e) {
            response = new HttpResponse<>(401, "账号不存在");
        } catch (NoAuthException e) {
            response = new HttpResponse<>(403, "密码错误");
        } catch (Exception e) {
            e.printStackTrace();
            response = new HttpResponse<>(500, "服务器错误");
        }
        return response;
    }


}

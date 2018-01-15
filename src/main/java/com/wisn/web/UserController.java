package com.wisn.web;


import com.wisn.HttpResponse;
import com.wisn.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public HttpResponse<User> register(@RequestBody User user) {
        System.out.println(" data:" + user);
        HttpResponse<User> response = new HttpResponse<>();
        response.code = 200;
        response.message = "success";
        response.data = user;
        return response;
    }

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public HttpResponse<User> login(@RequestBody User user) {
        System.out.println(" data:" + user);
        HttpResponse<User> response = new HttpResponse<>();
        response.code = 200;
        response.message = "success";
        response.data = user;
        return response;
    }
}

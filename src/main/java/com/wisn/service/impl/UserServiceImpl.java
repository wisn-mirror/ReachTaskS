package com.wisn.service.impl;

import com.wisn.dao.UserDao;
import com.wisn.entity.User;
import com.wisn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public boolean register(User user) {
        user.setRegistertime(System.currentTimeMillis());
        user.setLastlogintime(System.currentTimeMillis());
        int i = userDao.insertUser(user);
        System.out.println("register---"+i);
        return false;
    }

    @Override
    public User login(String phoneNumber, String password) {
        System.out.println("login----");
        User user = userDao.queryUserByPhoneNumber(phoneNumber);
        if(password.equals(user.getPassword())){
            return user;
        }
        return null;
    }
}

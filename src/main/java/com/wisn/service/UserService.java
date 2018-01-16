package com.wisn.service;

import com.wisn.entity.User;

public interface UserService {

    boolean register(User user);

    User login(String phoneNumber, String password);
}


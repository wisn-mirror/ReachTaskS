package com.wisn.service;

import com.wisn.entity.User;
import com.wisn.exception.AlreadyRegisteredException;
import com.wisn.exception.ParameterException;
import com.wisn.exception.UnRegisteredException;

import java.util.List;

public interface UserService {

    boolean register(User user)throws AlreadyRegisteredException, ParameterException;

    User login(String phoneNumber, String password)throws UnRegisteredException, ParameterException;

    List<User> getUsers(int offset,  int limit);
}


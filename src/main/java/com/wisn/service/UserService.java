package com.wisn.service;

import com.wisn.entity.User;
import com.wisn.exception.*;

import java.util.List;

public interface UserService {

    boolean register(User user) throws AlreadyRegisteredException, ParameterException;

    boolean updateIcon(User user) throws ParameterException;

    User login(String phoneNumber, String password) throws UnRegisteredException, ParameterException;

    List<User> getUsers(int offset, int limit);

    boolean updatePassword(long userid, String oldPassword, String newPassword) throws OperationException, ParameterException, NoAuthException, UnRegisteredException;

}


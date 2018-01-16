package com.wisn.service.impl;

import com.wisn.dao.UserDao;
import com.wisn.entity.User;
import com.wisn.exception.AlreadyRegisteredException;
import com.wisn.exception.NoAuthException;
import com.wisn.exception.ParameterException;
import com.wisn.exception.UnRegisteredException;
import com.wisn.service.UserService;
import com.wisn.tools.AESUtils;
import com.wisn.tools.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean register(User user) throws AlreadyRegisteredException, ParameterException {
        if (user == null || TextUtils.isEmpty(user.getPassword()) || TextUtils.isEmpty(user.getPhonenumber())) {
            throw new ParameterException("参数缺少");
        }
        User tempuser = userDao.queryUserByPhoneNumber(user.getPhonenumber());
        if (tempuser != null) {
            throw new AlreadyRegisteredException("已经注册");
        }
        String aesEncryption = AESUtils.AesEncryption(user.getPassword());
        user.setEncryption(aesEncryption);
        user.setRegistertime(System.currentTimeMillis());
        user.setLastlogintime(System.currentTimeMillis());
        int i = userDao.insertUser(user);
        if (i == 1) {
            return true;
        }
        return false;
    }

    @Override
    public User login(String phoneNumber, String password) throws UnRegisteredException, ParameterException {
        if (TextUtils.isEmpty(password) || TextUtils.isEmpty(phoneNumber)) {
            throw new ParameterException("参数缺少");
        }
        User user = userDao.queryUserByPhoneNumber(phoneNumber);
        if(user!=null){
            if (AESUtils.AesEncryption(password).equals(user.getEncryption()) && password.equals(user.getPassword())) {
                user.setEncryption("");
                user.setPassword("");
                return user;
            }else{
                throw new NoAuthException("账号密码错误");
            }
        }
        throw new UnRegisteredException("未注册");
    }

    @Override
    public List<User> getUsers(int offset, int limit) {
        List<User> users = userDao.queryAllUser(offset, limit);
        return users;
    }
}

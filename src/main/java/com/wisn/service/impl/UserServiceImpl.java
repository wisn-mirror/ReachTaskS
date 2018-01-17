package com.wisn.service.impl;

import com.wisn.dao.UserDao;
import com.wisn.entity.User;
import com.wisn.exception.*;
import com.wisn.protocol.session.TokenEntity;
import com.wisn.protocol.session.TokenManager;
import com.wisn.service.UserService;
import com.wisn.tools.AESUtils;
import com.wisn.tools.DateUtils;
import com.wisn.tools.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

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
        if (user != null) {
            if (AESUtils.AesEncryption(password).equals(user.getEncryption()) && password.equals(user.getPassword())) {
                Date dateAfterHours = DateUtils.getDateAfterHours(new Date(), 8);
                long expiredTime = dateAfterHours.getTime();
                String token = UUID.randomUUID().toString();
                user.setEncryption("");
                user.setPassword("");
                user.setToken(token);
                user.setExpired(expiredTime);
                user.setLastlogintime(System.currentTimeMillis());
                TokenManager.putToken(token, new TokenEntity(user.getUserid(), expiredTime));
                int i = userDao.updateToken(user);
                if (i != 1) throw new NoAuthException("登录失败");
                return user;
            } else {
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

    @Override
    public boolean updatePassword(long userid, String oldPassword, String newPassword) throws OperationException, ParameterException, NoAuthException, UnRegisteredException {
        if (TextUtils.isEmpty(oldPassword) || TextUtils.isEmpty(newPassword)) {
            throw new ParameterException("参数缺少");
        }
        User tempuser = userDao.queryUserById(userid);
        if (tempuser != null) {
            if (AESUtils.AesEncryption(oldPassword).equals(tempuser.getEncryption()) && oldPassword.equals(tempuser.getPassword())) {
                tempuser.setPassword(newPassword);
                int updatePassword = userDao.updatePassword(tempuser);
                if (updatePassword != 1) throw new OperationException("操作失败");
                Date dateAfterHours = DateUtils.getDateAfterHours(new Date(), 8);
                long expiredTime = dateAfterHours.getTime();
                String token = UUID.randomUUID().toString();
                tempuser.setToken(token);
                tempuser.setExpired(expiredTime);
                tempuser.setLastlogintime(System.currentTimeMillis());
                TokenManager.putToken(token, new TokenEntity(tempuser.getUserid(), expiredTime));
                int i = userDao.updateToken(tempuser);
                if (i != 1) throw new OperationException("操作失败");
                return true;
            } else {
                throw new NoAuthException("账号密码错误");
            }
        } else {
            throw new UnRegisteredException("账号未注册");
        }
    }
}

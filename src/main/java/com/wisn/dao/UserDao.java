package com.wisn.dao;

import com.wisn.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    User queryUserById(long userId);

    User queryUserByPhoneNumber(String phonenumber);

    List<User> queryAllUser(@Param("offset") int offset, @Param("limit") int limit);

    List<User> queryAllToken();

    int insertUser(User user);

    int updateUser(User user);

    int updateToken(User user);

    int updatePassword(User user);

    int updateIcon(User user);

    int deleteUserByUserId(int id);

}

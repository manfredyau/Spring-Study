package com.yau.mapper;

import com.yau.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> findUser();

    int addUser(User user);

    int deleteUser(int id);

    int updateUser(User user);
}

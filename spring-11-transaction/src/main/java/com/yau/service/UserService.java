package com.yau.service;

import com.yau.pojo.User;

import java.util.List;

public interface UserService {
    List<User> findUser();

    int addUser(User user);

    int deleteUser(int id);
}

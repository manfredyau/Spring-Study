package com.yau.service;

import com.yau.mapper.UserMapper;
import com.yau.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    @Autowired
    private ApplicationContext applicationContext;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public List<User> findUser() throws RuntimeException {
        UserService userService = applicationContext.getBean(UserService.class);
        User user = new User(999, "100", "100");
        userService.addUser(user);
        userService.deleteUser(100);
        return userMapper.findUser();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public int deleteUser(int id) {
        throw new RuntimeException();
//        return userMapper.deleteUser(id);
    }
}

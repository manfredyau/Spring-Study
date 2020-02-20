package com.yau.service;

import com.yau.mapper.UserMapper;
import com.yau.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service(value = "userService")
@Primary
public class UserServiceImpl implements UserService {
    private UserMapper userMapper;

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    /**
     * 因為在此僅定了一個構造函數，因此不需要在這上面標註 @Autowired，除非構造函數不止一個
     *
     * @param userMapper userMapper
     */
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User getUser(int id) {
        return userMapper.getUser(id);
    }

    public User getUserByTemplate(int id) {
        return sqlSessionTemplate.getMapper(UserMapper.class).getUser(id);
    }
}

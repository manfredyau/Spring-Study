package com.yau.service;

import com.yau.mapper.UserMapper;
import com.yau.pojo.User;
import org.mybatis.spring.support.SqlSessionDaoSupport;

public class UserServiceImpl2 extends SqlSessionDaoSupport implements UserService {
    @Override
    public User getUser(int id) {
        return getSqlSession().getMapper(UserMapper.class).getUser(id);
    }
}

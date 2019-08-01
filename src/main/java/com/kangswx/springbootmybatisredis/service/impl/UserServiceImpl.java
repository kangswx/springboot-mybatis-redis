package com.kangswx.springbootmybatisredis.service.impl;

import com.kangswx.springbootmybatisredis.domain.User;
import com.kangswx.springbootmybatisredis.mapper.UserMapper;
import com.kangswx.springbootmybatisredis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getByid(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

}

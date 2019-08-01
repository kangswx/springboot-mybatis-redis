package com.kangswx.springbootmybatisredis.service;

import com.kangswx.springbootmybatisredis.domain.User;

public interface UserService {

    User getByid(Integer id);

    int updateUser(User user);

    int deleteUserById(Integer id);

    int addUser(User user);
}

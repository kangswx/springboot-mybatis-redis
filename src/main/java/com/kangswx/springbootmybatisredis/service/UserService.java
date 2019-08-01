package com.kangswx.springbootmybatisredis.service;

import com.kangswx.springbootmybatisredis.domain.User;

public interface UserService {

    User getByid(Integer id);
}

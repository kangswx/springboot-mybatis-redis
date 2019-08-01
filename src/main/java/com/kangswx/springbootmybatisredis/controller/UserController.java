package com.kangswx.springbootmybatisredis.controller;

import com.kangswx.springbootmybatisredis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("get")
    public Object getById(int id){
        return userService.getByid(id);
    }
}

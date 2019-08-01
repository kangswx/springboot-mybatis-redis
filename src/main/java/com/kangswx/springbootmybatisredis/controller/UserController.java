package com.kangswx.springbootmybatisredis.controller;

import com.kangswx.springbootmybatisredis.domain.User;
import com.kangswx.springbootmybatisredis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public Object getById(int id){
        return userService.getByid(id);
    }

    @PutMapping()
    public Object updateUserById(@RequestBody User user){
        return userService.updateUser(user);
    }

    @PostMapping()
    public Object addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @DeleteMapping()
    public Object deleteUser(int id){
        return userService.deleteUserById(id);
    }

}

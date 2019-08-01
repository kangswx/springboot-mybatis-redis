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

    /**
     * 查询接口
     * @param id
     * @return
     */
    @GetMapping()
    public Object getById(int id){
        return userService.getByid(id);
    }

    /**
     * 修改接口
     * @param user
     * @return
     */
    @PutMapping()
    public Object updateUserById(@RequestBody User user){
        return userService.updateUser(user);
    }

    /**
     * 添加接口
     * @param user
     * @return
     */
    @PostMapping()
    public Object addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    /**
     * 删除接口
     * @param id
     * @return
     */
    @DeleteMapping()
    public Object deleteUser(int id){
        return userService.deleteUserById(id);
    }

}

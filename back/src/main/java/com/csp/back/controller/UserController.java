package com.csp.back.controller;

import com.csp.back.entity.User;
import com.csp.back.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @PostMapping
    public Integer save(@RequestBody User user){
        return userMapper.insert(user);
    }

    @GetMapping("/")
    public List<User> index() {
        return userMapper.findAllUser();
    }
}

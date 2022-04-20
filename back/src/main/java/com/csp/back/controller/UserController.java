package com.csp.back.controller;

import com.csp.back.entity.User;
import com.csp.back.mapper.UserMapper;
import com.csp.back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @PostMapping
    public boolean save(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping
    public List<User> findAll() {
        return userMapper.findAllUser();
    }

    @GetMapping("/page")
    public Map<String, Object> finPage(@RequestParam Integer pageNum,
                                       @RequestParam Integer pageSize) {
        pageNum = (pageNum - 1) * pageSize;
        List<User> data = userMapper.findPage(pageNum, pageSize);
        Integer total = userMapper.selectTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("data", data);
        return map;
    }

    @DeleteMapping()
    public Integer delete(@PathVariable Integer id) {
        return userMapper.deleteById(id);
    }
}

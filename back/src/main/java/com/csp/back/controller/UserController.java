package com.csp.back.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.csp.back.entity.User;

import com.csp.back.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author csp
 * @since 2022-04-23
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    //登录
    @PostMapping
    public boolean login(@RequestBody User user) {
        return userService.saveOrUpdate(user);
    }

    //新增或修改
    @PostMapping
    public boolean save(@RequestBody User user) {
            return userService.saveOrUpdate(user);
    }

    //获取列表
    @GetMapping
    public List<User> findAll() {
            return userService.list();
    }

    //根据ID删除
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
            return userService.removeById(id);
    }

    //带过滤器的分页查询
    @GetMapping("/page")
    public IPage<User> finPage(@RequestParam Integer pageNum,
                               @RequestParam Integer pageSize) {
        IPage<User> page = new Page<>(pageNum,pageSize);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        return userService.page(page,queryWrapper);
    }

}

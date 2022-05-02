package com.csp.back.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.csp.back.common.Constants;
import com.csp.back.common.Result;
import com.csp.back.controller.dto.UserDTO;
import com.csp.back.entity.User;

import com.csp.back.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author csp
 * @since 2022-04-23
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    //登录
    @PostMapping("/login")
    public Result login(@RequestBody UserDTO userDTO) {
        String username = userDTO.getUsername();
        String password = userDTO.getPassword();
        if (StrUtil.isBlank(username) || StrUtil.isBlank(password))
            return Result.error(Constants.CODE_400, "参数错误");
        return Result.success(userService.login(userDTO));
    }

    //注册
    @PostMapping("/register")
    public Result register(@RequestBody UserDTO userDTO) {
        String schoolNumber = userDTO.getSchoolNumber();
        String username = userDTO.getUsername();
        String password = userDTO.getPassword();
        String rePassword = userDTO.getRePassword();
        if (!password.equals(rePassword))
            return Result.error(Constants.CODE_400, "参数错误");
        if (StrUtil.isBlank(schoolNumber) || StrUtil.isBlank(username) || StrUtil.isBlank(password) || StrUtil.isBlank(rePassword))
            return Result.error(Constants.CODE_400, "参数错误");
        return Result.success(userService.register(userDTO));
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
        IPage<User> page = new Page<>(pageNum, pageSize);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        return userService.page(page, queryWrapper);
    }

}

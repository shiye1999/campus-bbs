package com.csp.back.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.csp.back.common.Result;
import com.csp.back.controller.dto.UserDTO;
import com.csp.back.entity.Relation;
import com.csp.back.entity.User;

import com.csp.back.service.IRelationService;
import com.csp.back.service.IUserService;
import io.swagger.v3.oas.annotations.Parameter;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.LinkedList;
import java.util.List;

import static com.csp.back.common.Constants.CODE_400;
import static com.csp.back.utils.TokenUtils.getCurrentUser;

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

    //relation就不要controller算了
    @Autowired
    private IRelationService relationService;

    //登录
    @PostMapping("/login")
    public Result login(@RequestBody UserDTO userDTO) {
        String username = userDTO.getUsername();
        String password = userDTO.getPassword();
        if (StrUtil.isBlank(username) || StrUtil.isBlank(password))
            return Result.error(CODE_400, "参数错误");
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
            return Result.error(CODE_400, "参数错误");
        if (StrUtil.isBlank(schoolNumber) || StrUtil.isBlank(username) || StrUtil.isBlank(password) || StrUtil.isBlank(rePassword))
            return Result.error(CODE_400, "参数错误");
        return Result.success(userService.register(userDTO));
    }

    //新增或修改
    @PostMapping
    public Result save(@RequestBody User user) {
        if (user.getId() == null && user.getPassword() == null) {  // 新增用户默认密码
            user.setPassword("123456");
        }
        return Result.success(userService.saveOrUpdate(user));
    }

    //修改密码
    @PostMapping("/updatePWD")
    public Result updatePWD(@RequestBody UserDTO userDTO) {
        User user = getCurrentUser();
        String password = userDTO.getPassword();
        String rePassword = userDTO.getRePassword();
        if(!password.equals(user.getPassword())){
            return Result.error(CODE_400,"密码错误");
        }
        user.setPassword(rePassword);
        userService.saveOrUpdate(user);
        return Result.success();
    }

    //修改用户名
    @PostMapping("/updateName")
    public Result updateName(@RequestBody UserDTO userDTO) {
        User user = getCurrentUser();
        user.setUsername(userDTO.getUsername());
        userService.saveOrUpdate(user);
        return Result.success();
    }

    //修改头像
    @PostMapping("/updateAvatarUrl")
    public Result updateAvatar(@RequestParam String avatarUrl) {
        User user = getCurrentUser();
        user.setAvatarUrl(avatarUrl);
        userService.saveOrUpdate(user);
        return Result.success(user);
    }

    //获取用户列表
    @GetMapping
    public Result findAll() {
        return Result.success(userService.list());
    }

    @GetMapping("/{id}")
    public Result findUser(@PathVariable Integer id) {
        User user = userService.getById(id);
        user.setPassword("");
        return Result.success(user);
    }

    @GetMapping("/username/{username}")
    public Result findByUsername(@PathVariable String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        return Result.success(userService.getOne(queryWrapper));
    }

    //粉丝总数，select关注
    @GetMapping("relation/subscriberNumber")
    public Result getPublisherNumber(){
        User user = getCurrentUser();
        Integer id = user.getId();
        QueryWrapper<Relation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("publisher_id",id);
        return Result.success(relationService.list(queryWrapper).size());
    }

    //关注总数，select粉丝
    @GetMapping("relation/publisherNumber")
    public Result getSubscriberNumber(){
        User user = getCurrentUser();
        Integer id = user.getId();
        QueryWrapper<Relation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("subscriber_id",id);
        return Result.success(relationService.list(queryWrapper).size());
    }

    //粉丝List
    @GetMapping("relation/publisherList")
    public Result getPublisherList(){
        User user = getCurrentUser();
        Integer id = user.getId();
        QueryWrapper<Relation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("subscriber_id",id);
        List<Integer> ids = new LinkedList<>();
        for(Relation r :relationService.list(queryWrapper)){
            ids.add(r.getPublisherId());
        }
        List<User> users = new LinkedList<>();
        for(Integer i:ids){
            users.add(userService.getById(i));
        }
        return Result.success(users);
    }

    //关注List
    @GetMapping("relation/subscriberList")
    public Result getSubscriberList(){
        User user = getCurrentUser();
        Integer id = user.getId();
        QueryWrapper<Relation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("publisher_id",id);
        List<Integer> ids = new LinkedList<>();
        for(Relation r :relationService.list(queryWrapper)){
            ids.add(r.getSubscriberId());
        }
        List<User> users = new LinkedList<>();
        for(Integer i:ids){
            users.add(userService.getById(i));
        }
        return Result.success(users);
    }

    //获取当前权限
    @GetMapping("/auth")
    public Integer getAuth() {
        User user = getCurrentUser();
        return user.getAuthority();
    }

    //带过滤器的分页查询
    @GetMapping("/page")
    public Result finPage(@RequestParam Integer pageNum,
                          @RequestParam Integer pageSize) {
        IPage<User> page = new Page<>(pageNum, pageSize);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        return Result.success(userService.page(page, queryWrapper));
    }

    //根据ID删除
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return Result.success(userService.removeById(id));
    }


}

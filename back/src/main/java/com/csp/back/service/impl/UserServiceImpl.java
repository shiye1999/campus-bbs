package com.csp.back.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.log.Log;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.csp.back.common.Constants;
import com.csp.back.controller.dto.UserDTO;
import com.csp.back.entity.User;
import com.csp.back.exception.ServiceException;
import com.csp.back.mapper.UserMapper;
import com.csp.back.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.csp.back.utils.TokenUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author csp
 * @since 2022-04-23
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    //日志
    private static final Log log = Log.get();

    @Override
    public UserDTO login(UserDTO userDTO) {
        User one = getUserInfo(userDTO);
        if(one != null ){
            BeanUtil.copyProperties(one,userDTO,true);
            //设置token
            String token = TokenUtils.genToken(one.getId().toString(),one.getPassword());
            userDTO.setToken(token);
            return userDTO;
        }
        else{
            throw new ServiceException(Constants.CODE_600,"用户名或密码错误");
        }
    }

    @Override
    public User register(UserDTO userDTO) {
        User one = getUserInfo(userDTO);
        if(one == null){
            User user = new User();
            BeanUtil.copyProperties(userDTO,user,true);
            save(user);
            return user;
        }
        else{
            throw new ServiceException(Constants.CODE_600,"用户已存在");
        }
    }

    private User getUserInfo(UserDTO userDTO){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", userDTO.getUsername());
        queryWrapper.eq("password", userDTO.getPassword());
        User one;
        try {
            one = getOne(queryWrapper);
            return one;
        }catch(Exception e){
            log.error(e);
            throw new ServiceException(Constants.CODE_500,"系统错误");
        }
    }

}

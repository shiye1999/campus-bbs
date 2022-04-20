package com.csp.back.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.csp.back.entity.User;
import com.csp.back.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<UserMapper,User> {

    public boolean saveUser(User user){
        return saveOrUpdate(user);
    }
}

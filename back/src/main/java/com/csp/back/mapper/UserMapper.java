package com.csp.back.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.csp.back.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

//要么在这里写sql（通过注解）
//要么在xml里面写（通过xml）
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from user")
    List<User> findAllUser();

    @Select("select * from user limit #{param1},#{param2}")
    List<User> findPage(Integer pageNum,Integer pageSize);

    @Insert("insert into user(authority,school_number,username,password) values (#{authority},#{school_number},#{username},#{password})")
    int insert(User user);

    @Select("select count(*) from user where username like concat('%',#{username},'%')")
    List<User> searchByName(String username);

    @Select("select count(*) from user")
    Integer selectTotal();

}
/*
{
    "authority":"1"
    "school_number":"123456"
    "username":"test1"
    "password":"123456"
}
 */
package com.csp.back.mapper;

import com.csp.back.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user")
    List<User> findAllUser();

    @Insert("insert into user(authority,school_number,username,password) values (#{authority},#{school_number},#{username},#{password}")
    int insert(User user);
}

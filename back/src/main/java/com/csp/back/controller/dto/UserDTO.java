package com.csp.back.controller.dto;

import lombok.Data;

//接受前端登录的数据
@Data
public class UserDTO {
    private String schoolNumber;
    private String username;
    private String password;
    private String rePassword;
    private String avatar;
    private String token;

    public String getSchoolNumber() {
        return schoolNumber;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRePassword() {
        return rePassword;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

package com.csp.back.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private Integer authority;
    private String school_number;
    private String username;
    private String password;
    private String avatar;
    private Integer comment_number;
    private String last_time;
    private String create_time;

}

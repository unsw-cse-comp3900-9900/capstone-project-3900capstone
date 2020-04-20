package com.project.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    private Integer userId;
    private Integer zId;
    private String userName;
    private String userPwd;
    private Integer phone;
    private String email;
    private String department;
    private String address;
    private String auth;

}

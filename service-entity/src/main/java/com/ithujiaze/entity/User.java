package com.ithujiaze.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int user_Id;
    private String phone;
    private String password;
    private String affiliation;
    private String username;
    private  Role role;
    private int is_Delete;
    private int is_Login;
}

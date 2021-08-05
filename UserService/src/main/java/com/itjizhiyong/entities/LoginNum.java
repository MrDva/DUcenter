package com.itjizhiyong.entities;

import com.ithujiaze.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginNum {
    private String phone;//之前未int
    private String affiliation;
    private String Username;
    private Role role;
    private int User_Id;
//    private int phone;
    private String password;
//    private String affiliation;
//    private String username;
//    private Role role;
//    private int is_Delete;
//    private int is_Login;
//public void setRole(int role_id, List<Authority> authoritys, int role_level, String affiliation, String role_name) {
//}
}


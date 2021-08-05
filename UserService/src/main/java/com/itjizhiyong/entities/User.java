package com.itjizhiyong.entities;

import com.ithujiaze.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int User_Id;
    private String Password;
    private String Affiliation;
    private String username;
    private String Phone;
    private int Role_Id;
//    private int Is_Delete;
//    private int Is_Login;
}

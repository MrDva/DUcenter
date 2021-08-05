package com.itjizhiyong.entities;

import com.itjizhiyong.entities.Authority;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private int role_Id;
    private String role_Name;
    private int role_Level;
    private List<Authority> authoritys;
}

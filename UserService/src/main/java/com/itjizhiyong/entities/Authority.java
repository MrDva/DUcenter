package com.itjizhiyong.entities;

import com.ithujiaze.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Authority {
    private int authority_Id;
    private String authority_Name;
    private List<Role> roles;
}

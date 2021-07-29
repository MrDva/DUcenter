package com.ithujiaze.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role_Authority {
    private int role_Authority_Id;
    private  int role_Id;
    private int authority_Id;
}

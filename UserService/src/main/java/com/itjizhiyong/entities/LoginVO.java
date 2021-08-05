package com.itjizhiyong.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginVO {
    private String phone;
    private String password;
    private String mac;
    private String ip;
}

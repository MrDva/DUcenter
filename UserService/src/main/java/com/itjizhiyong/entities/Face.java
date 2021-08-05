package com.itjizhiyong.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Face {
    private String phone;
    private String password;
    private String mac;
    private String ip;
    private String face;
}

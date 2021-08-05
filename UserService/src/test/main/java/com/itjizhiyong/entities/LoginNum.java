package com.itjizhiyong.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginNum {
    private Integer code;
    private String message;
    private String token;
}

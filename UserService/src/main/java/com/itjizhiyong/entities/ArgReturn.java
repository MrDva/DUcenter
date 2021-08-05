package com.itjizhiyong.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArgReturn {
    private String token;
    private String code;
    private String message;
}

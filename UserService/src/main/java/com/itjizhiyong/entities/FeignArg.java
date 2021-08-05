package com.itjizhiyong.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeignArg {
    private String mac;
    private String ip;
    private String phone;
}

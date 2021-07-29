package com.ithujiaze.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Three_DateCount {
    private  String mac;
    private Timestamp datetime;
    private String username;
    private String phone;
    private int count;
}

package com.ithujiaze.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Login_Data {
    private int access_id;
    private User user;//账号本人
    private String mac;
    private String address;
    private String point_X;
    private String point_Y;
    private Timestamp datetime;
}

package com.ithujiaze.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Three_Data {
    private int access_id;
    private User user;//权限授予者
    private String mac;
    private String address;
    private Timestamp datetime;
}

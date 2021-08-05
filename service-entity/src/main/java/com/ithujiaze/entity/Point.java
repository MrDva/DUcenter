package com.ithujiaze.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Point {
    private String point_x;
    private String point_y;
    private boolean flag;
    private String address;

}

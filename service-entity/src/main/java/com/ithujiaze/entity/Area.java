package com.ithujiaze.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Area {
    private  int area_Id;
    private  String area_Name;
    private int city_Id;
}

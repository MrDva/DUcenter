package com.ithujiaze.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Province {
    private  int provinceId;
    private String provinceName;
    private List<city> citysName;
}

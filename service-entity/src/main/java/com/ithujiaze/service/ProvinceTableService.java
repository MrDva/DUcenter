package com.ithujiaze.service;

import com.itchenyang.result.R;
import com.ithujiaze.entity.Province;

import java.util.List;

public interface ProvinceTableService {
    public List<Province> GetCityByP(String name);

    public List<Province> GetCity();

    public R insertP(Province province);

}

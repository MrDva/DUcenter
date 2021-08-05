package com.ithujiaze.service;

import com.itchenyang.result.R;
import com.ithujiaze.entity.city;

import java.util.List;
import java.util.Map;

public interface CityService {
    public R GetCity();
    public R GetCityByString(String name);
    public R insertCity(Map<String,String> map);
}

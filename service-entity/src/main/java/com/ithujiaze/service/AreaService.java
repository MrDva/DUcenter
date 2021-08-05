package com.ithujiaze.service;

import com.itchenyang.result.R;
import com.ithujiaze.entity.Area;

import java.util.List;
import java.util.Map;

public interface AreaService {
    public R GetAreaByCity(int id);

    public R GetAreaByCity(String name);

    public R insertArea(Map<String, String> map);
}

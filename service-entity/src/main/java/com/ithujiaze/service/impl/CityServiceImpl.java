package com.ithujiaze.service.impl;

import com.itchenyang.result.R;
import com.ithujiaze.dao.CityTableMapper;
import com.ithujiaze.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityTableMapper cityTableMapper;
    @Override
    public R GetCity() {
        return R.ok().playMessage("成功").playData("citys",cityTableMapper.GetCity());
    }

    @Override
    public R GetCityByString(String name) {
        return R.ok().playMessage("成功").playData("citys",cityTableMapper.GetCityByP(name));
    }

    @Override
    public R insertCity(Map<String, String> map) {
        return R.ok().playMessage("成功").playData("num",cityTableMapper.insertCity(map));
    }
}

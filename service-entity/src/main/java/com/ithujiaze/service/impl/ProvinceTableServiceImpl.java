package com.ithujiaze.service.impl;

import com.itchenyang.result.R;
import com.ithujiaze.dao.ProvinceTableMapper;
import com.ithujiaze.entity.Province;
import com.ithujiaze.service.ProvinceTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProvinceTableServiceImpl implements ProvinceTableService {
    @Autowired
    private ProvinceTableMapper provinceTableMapper;
    @Override
    public List<Province> GetCityByP(String name) {
        return provinceTableMapper.GetCityByP(name+"%");
    }

    @Override
    public List<Province> GetCity() {
        return provinceTableMapper.GetCity();
    }

    @Override
    public R insertP(Province province) {
        return R.ok().playMessage("成功").playData("num",provinceTableMapper.insertP(province));
    }
}

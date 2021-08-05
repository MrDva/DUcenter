package com.ithujiaze.service.impl;

import com.itchenyang.result.R;
import com.ithujiaze.dao.AreaTableMapper;
import com.ithujiaze.entity.Area;
import com.ithujiaze.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaTableMapper areaTableMapper;
    @Override
    public R GetAreaByCity(int id) {
        return R.ok().playMessage("成功").playData("Area",areaTableMapper.GetAreaByCity(id));
    }

    @Override
    public R GetAreaByCity(String name) {
        return R.ok().playMessage("成功").playData("Area",areaTableMapper.GetAreaByCityString(name));
    }

    @Override
    public R insertArea(Map<String, String> map) {
        return R.ok().playMessage("成功").playData("num",areaTableMapper.insertArea(map));
    }
}

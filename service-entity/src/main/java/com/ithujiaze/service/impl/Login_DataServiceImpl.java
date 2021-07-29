package com.ithujiaze.service.impl;

import com.itchenyang.result.R;
import com.ithujiaze.dao.Login_DataTableMapper;
import com.ithujiaze.entity.Login_Data;
import com.ithujiaze.entity.Province;
import com.ithujiaze.service.Login_DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Login_DataServiceImpl implements Login_DataService {
    @Autowired
    private Login_DataTableMapper login_dataTableMapper;
    @Override
    public R GetLogin_DataById(int id) {
        return R.ok().playCode(200).playMessage("成功").playData("login_data",login_dataTableMapper.GetLogin_DataById(id));
    }

    @Override
    public R GetLogin_DataByIdNowDay(int id) {
        return R.ok().playCode(200).playMessage("成功").playData("login_data",login_dataTableMapper.GetLogin_DataByIdNowDay(id));
    }

    @Override
    public R GetLogin_DataByIdSevenDay(int id) {
        return R.ok().playCode(200).playMessage("成功").playData("login_data",login_dataTableMapper.GetLogin_DataByIdSevenDay(id));
    }

    @Override
    public R GetLogin_DataByIdOneMonth(int id) {
        return R.ok().playCode(200).playMessage("成功").playData("login_data",login_dataTableMapper.GetLogin_DataByIdOneMonth(id));
    }

    @Override
    public R Insert(Login_Data login_data) {
        java.util.Date date=new java.util.Date();
        Timestamp sqlDate = new Timestamp(date.getTime());
        login_data.setDatetime(sqlDate);
        return  R.ok().playCode(200).playMessage("成功").playData("login_data",login_dataTableMapper.Insert(login_data));
    }

    @Override
    public R GetLogin_DataByAddress(String address) {
        return  R.ok().playCode(200).playMessage("成功").playData("login_data",login_dataTableMapper.GetLogin_DataByAddress("%"+address+"%"));
    }

    @Override
    public R GetLogin_DataByAddressNowDay(String address) {
        return  R.ok().playCode(200).playMessage("成功").playData("login_data",login_dataTableMapper.GetLogin_DataByAddressNowDay("%"+address+"%"));
    }

    @Override
    public R GetLogin_DataByAddressSevenDay(String address) {
        return  R.ok().playCode(200).playMessage("成功").playData("login_data",login_dataTableMapper.GetLogin_DataByAddressSevenDay("%"+address+"%"));
    }

    @Override
    public R GetLogin_DataByAddressOneMonth(String address) {
        return  R.ok().playCode(200).playMessage("成功").playData("login_data",login_dataTableMapper.GetLogin_DataByAddressOneMonth("%"+address+"%"));
    }

    @Override
    public R GetLogin_NumByAddress(List<Province> citys) {
        Map<String, Integer> city = new HashMap<>();
        for (Province province:citys) {
            String provinceName=province.getProvinceName();
            for (String cityName:province.getCitysName()) {
                city.put(cityName,login_dataTableMapper.GetLogin_NumByAddress("%"+provinceName+"%"+cityName+"%"));
            }
        }
        return R.ok().playCode(200).playMessage("成功").playData("city",city);
    }

    @Override
    public R GetLogin_NumByAddressNowDay(List<Province> citys) {
        Map<String, Integer> city = new HashMap<>();
        for (Province province:citys) {
            String provinceName=province.getProvinceName();
            for (String cityName:province.getCitysName()) {
                city.put(cityName,login_dataTableMapper.GetLogin_NumByAddressNowDay("%"+provinceName+"%"+cityName+"%"));
            }
        }
        return R.ok().playCode(200).playMessage("成功").playData("city",city);
    }

    @Override
    public R GetLogin_NumByAddressSevenDay(List<Province> citys) {
        Map<String, Integer> city = new HashMap<>();
        for (Province province:citys) {
            String provinceName=province.getProvinceName();
            for (String cityName:province.getCitysName()) {
                city.put(cityName,login_dataTableMapper.GetLogin_NumByAddressSevenDay("%"+provinceName+"%"+cityName+"%"));
            }
        }
        return R.ok().playCode(200).playMessage("成功").playData("city",city);
    }

    @Override
    public R GetLogin_NumByAddressOneMonth(List<Province> citys) {
        Map<String, Integer> city = new HashMap<>();
        for (Province province:citys) {
            String provinceName=province.getProvinceName();
            for (String cityName:province.getCitysName()) {
                city.put(cityName,login_dataTableMapper.GetLogin_NumByAddressOneMonth("%"+provinceName+"%"+cityName+"%"));
            }
        }
        return R.ok().playCode(200).playMessage("成功").playData("city",city);
    }

    @Override
    public R DeleteLogin_DataByThreeMonth() {
        return  R.ok().playCode(200).playMessage("成功").playData("login_data",login_dataTableMapper.DeleteLogin_DataByThreeMonth());
    }
}

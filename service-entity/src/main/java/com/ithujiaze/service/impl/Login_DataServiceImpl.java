package com.ithujiaze.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itchenyang.result.R;
import com.ithujiaze.dao.Login_DataTableMapper;
import com.ithujiaze.entity.Authority;
import com.ithujiaze.entity.Login_Data;
import com.ithujiaze.entity.Page;
import com.ithujiaze.entity.Point;
import com.ithujiaze.entity.Province;
import com.ithujiaze.service.Login_DataService;
import com.ithujiaze.untils.address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Login_DataServiceImpl implements Login_DataService {
    @Autowired
    private Login_DataTableMapper login_dataTableMapper;

    @Autowired
    private com.ithujiaze.untils.address address;

    @Override
    public R GetLogin_DataById(int id) {
        return R.ok().playCode(200).playMessage("成功").playData("login_data", login_dataTableMapper.GetLogin_DataById(id));
    }

    @Override
    public Point login(String mac, String ip, String phone) {
        Point point =address.getPoint(ip);
        Login_Data login_data = login_dataTableMapper.GetLogin_DataByPhoneNew(phone);
        if(login_data!=null) {
            double x = Double.parseDouble(login_data.getPoint_X());
            double y = Double.parseDouble(login_data.getPoint_Y());
            double x_get = Double.parseDouble(point.getPoint_x());
            double y_get = Double.parseDouble(point.getPoint_y());
            double long_place = Math.sqrt(Math.pow(x - x_get, 2) + Math.pow(y - y_get, 2));
            if (long_place < 50.0 || login_data.getMac().equals(mac)) {
                point.setFlag(false);
                return point;
            }
        }
        point.setFlag(true);
        return point;
    }

    @Override
    public R GetLogin_DataByIdNowDay(int id) {
        return R.ok().playCode(200).playMessage("成功").playData("login_data", login_dataTableMapper.GetLogin_DataByIdNowDay(id));
    }

    @Override
    public R GetLogin_DataByIdSevenDay(int id) {
        return R.ok().playCode(200).playMessage("成功").playData("login_data", login_dataTableMapper.GetLogin_DataByIdSevenDay(id));
    }

    @Override
    public R GetLogin_DataByIdOneMonth(int id) {
        return R.ok().playCode(200).playMessage("成功").playData("login_data", login_dataTableMapper.GetLogin_DataByIdOneMonth(id));
    }

    @Override
    public R Insert(Login_Data login_data) {
        java.util.Date date = new java.util.Date();
        Timestamp sqlDate = new Timestamp(date.getTime());
        login_data.setDatetime(sqlDate);
        return R.ok().playCode(200).playMessage("成功").playData("login_data", login_dataTableMapper.Insert(login_data));
    }

    @Override
    public R GetLogin_DataByAddress(String address) {
        return R.ok().playCode(200).playMessage("成功").playData("login_data", login_dataTableMapper.GetLogin_DataByAddress("%" + address + "%"));
    }

    @Override
    public R GetLogin_DataByAddressNowDay(String address) {
        return R.ok().playCode(200).playMessage("成功").playData("login_data", login_dataTableMapper.GetLogin_DataByAddressNowDay("%" + address + "%"));
    }

    @Override
    public R GetLogin_DataByAddressSevenDay(String address) {
        return R.ok().playCode(200).playMessage("成功").playData("login_data", login_dataTableMapper.GetLogin_DataByAddressSevenDay("%" + address + "%"));
    }

    @Override
    public R GetLogin_DataByAddressOneMonth(String address) {
        return R.ok().playCode(200).playMessage("成功").playData("login_data", login_dataTableMapper.GetLogin_DataByAddressOneMonth("%" + address + "%"));
    }

    @Override
    public R GetLogin_NumByAddress(List<Province> citys) {
        Map<String, Integer> city = new HashMap<>();
        for (Province province : citys) {
            String provinceName = province.getProvinceName();
            for (String cityName : province.getCitysName()) {
                city.put(cityName, login_dataTableMapper.GetLogin_NumByAddress("%" + provinceName + "%" + cityName + "%"));
            }
        }
        return R.ok().playCode(200).playMessage("成功").playData("city", city);
    }

    @Override
    public R GetLogin_NumByAddressNowDay(List<Province> citys) {
        Map<String, Integer> city = new HashMap<>();
        for (Province province : citys) {
            String provinceName = province.getProvinceName();
            for (String cityName : province.getCitysName()) {
                city.put(cityName, login_dataTableMapper.GetLogin_NumByAddressNowDay("%" + provinceName + "%" + cityName + "%"));
            }
        }
        return R.ok().playCode(200).playMessage("成功").playData("city", city);
    }

    @Override
    public R GetLogin_NumByAddressSevenDay(List<Province> citys) {
        Map<String, Integer> city = new HashMap<>();
        for (Province province : citys) {
            String provinceName = province.getProvinceName();
            for (String cityName : province.getCitysName()) {
                city.put(cityName, login_dataTableMapper.GetLogin_NumByAddressSevenDay("%" + provinceName + "%" + cityName + "%"));
            }
        }
        return R.ok().playCode(200).playMessage("成功").playData("city", city);
    }

    @Override
    public R GetLogin_NumByAddressOneMonth(List<Province> citys) {
        Map<String, Integer> city = new HashMap<>();
        for (Province province : citys) {
            String provinceName = province.getProvinceName();
            for (String cityName : province.getCitysName()) {
                city.put(cityName, login_dataTableMapper.GetLogin_NumByAddressOneMonth("%" + provinceName + "%" + cityName + "%"));
            }
        }
        return R.ok().playCode(200).playMessage("成功").playData("city", city);
    }

    @Override
    public R DeleteLogin_DataByThreeMonth() {
        return R.ok().playCode(200).playMessage("成功").playData("login_data", login_dataTableMapper.DeleteLogin_DataByThreeMonth());
    }

    @Override
    public R GetPageAll(int page) {
        PageHelper.startPage(page, Page.ok().getPageSize());
        PageInfo<Login_Data> userInfoPage = new PageInfo<Login_Data>(login_dataTableMapper.GetLogin_DataAll());
        return R.ok().playCode(200).playMessage("成功").playData("authority", userInfoPage.getList())
                .playData("page", page).playData("pages", userInfoPage.getPages());
    }
}

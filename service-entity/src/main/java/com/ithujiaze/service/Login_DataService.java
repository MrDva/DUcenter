package com.ithujiaze.service;

import com.itchenyang.result.R;
import com.ithujiaze.entity.Login_Data;
import com.ithujiaze.entity.Point;
import com.ithujiaze.entity.Province;

import java.util.List;

public interface Login_DataService {
    public R GetLogin_DataById(int id);

    public Point login(String mac, String ip, String phone);

    public R GetLogin_DataByIdNowDay(int id);

    public R GetLogin_DataByIdSevenDay(int id);

    public R GetLogin_DataByIdOneMonth(int id);

    public R Insert(Login_Data login_data);

    public R GetLogin_DataByAddress(String address);

    public R GetLogin_DataByAddressNowDay(String address);

    public R GetLogin_DataByAddressSevenDay(String address);

    public R GetLogin_DataByAddressOneMonth(String address);

    public R GetLogin_NumByAddress(List<Province> citys);

    public R GetLogin_NumByAddressNowDay(List<Province> citys);

    public R GetLogin_NumByAddressSevenDay(List<Province> citys);

    public R GetLogin_NumByAddressOneMonth(List<Province> citys);

    public R DeleteLogin_DataByThreeMonth();

    public  R GetPageAll(int page);
}

package com.ithujiaze.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itchenyang.result.R;
import com.ithujiaze.dao.AreaTableMapper;
import com.ithujiaze.dao.CityTableMapper;
import com.ithujiaze.dao.Login_DataTableMapper;
import com.ithujiaze.dao.ProvinceTableMapper;
import com.ithujiaze.entity.*;
import com.ithujiaze.entity.Point;
import com.ithujiaze.service.AreaService;
import com.ithujiaze.service.CityService;
import com.ithujiaze.service.Login_DataService;
import com.ithujiaze.service.ProvinceTableService;
import com.ithujiaze.untils.address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class Login_DataServiceImpl implements Login_DataService {
    @Autowired
    private ProvinceTableMapper provinceTableMapper;
    @Autowired
    private CityTableMapper cityTableMapper;
    @Autowired
    private AreaTableMapper areaTableMapper;

    @Autowired
    private Login_DataTableMapper login_dataTableMapper;

    @Autowired
    private com.ithujiaze.untils.address address;

    @Override
    public R GetLogin_DataAll() {
        return R.ok().playMessage("成功").playData("login_data",login_dataTableMapper.GetLogin_DataAll());
    }

    @Override
    public R GetLogin_DataById(int id) {
        return R.ok().playCode(200).playMessage("成功").playData("login_data", login_dataTableMapper.GetLogin_DataById(id));
    }

    @Override
    public R GetLogin_DataByIdAndPage(int id, int page) {
        PageHelper.startPage(page, Page.ok().getPageSize());
        PageInfo<Login_Data> userInfoPage = new PageInfo<Login_Data>(login_dataTableMapper.GetLogin_DataById(id));
        return R.ok().playCode(200).playMessage("成功").playData("login_data", userInfoPage.getList())
                .playData("page", page).playData("pages", userInfoPage.getPages());
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
    //点击左侧菜单栏第一次登陆
    @Override
    public R GetLogin_DataByAddress_one(String address,int page) {

        if(!address.contains("%")){
            System.out.println("%");

            List<Province> list=provinceTableMapper.GetProvinces();
            Province province=new Province();
            province.setProvinceName("不限");
            list.add(1,province);

            List<city> citylist=new ArrayList<>();
            List<Area> arealist=new ArrayList<>();

//            PageHelper.startPage(page, Page.ok().getPageSize());
//            PageInfo<Login_Data> userInfoPage = new PageInfo<Login_Data>(login_dataTableMapper.GetLogin_DataByAddress(address+"%"));
//            return R.ok().playCode(200).playMessage("成功").playData("login_data", userInfoPage.getList())
//                    .playData("page", page).playData("pages", userInfoPage.getPages()).playData("province",list).
//                            playData("city",citylist).playData("area",arealist);
        }
        if(address.indexOf("%")==address.lastIndexOf("%")){
            address=address.replace(address.substring(address.indexOf("%")+1,address.length()),"");
            System.out.println(address);

            List<Province> provincelist=new ArrayList<>();
            provincelist.add(new Province(0,address.replace("%",""),null));

            List<city> list=cityTableMapper.GetCityByP(address);
            city city=new city();
            city.setName("不限");
            list.add(1,city);

            List<Area> arealist=new ArrayList<>();

            PageHelper.startPage(page, Page.ok().getPageSize());
            PageInfo<Login_Data> userInfoPage = new PageInfo<Login_Data>(login_dataTableMapper.GetLogin_DataByAddress(address));
            return R.ok().playCode(200).playMessage("成功").playData("login_data", userInfoPage.getList())
                    .playData("page", page).playData("pages", userInfoPage.getPages()).playData("province",provincelist).
                            playData("city",list).playData("area",arealist);
        }
        if(address.indexOf("%")!=address.lastIndexOf("%")){
            String  address1=address.replace(address.substring(address.lastIndexOf("%")+1,address.length()),"");
            System.out.println(address1);
            String province=address.substring(0,address.indexOf("%"));
            String city=address.substring(address.indexOf("%")+1,address.lastIndexOf("%"));
            List<Province> provincelist=new ArrayList<>();
            provincelist.add(new Province(0,province,null));

            List<city> cityList = new ArrayList<>();
            cityList.add(new city(city,0,0));

            List<Area> list=areaTableMapper.GetAreaByCityString(city+"%");
            Area area=new Area();
            area.setArea_Name("不限");
            list.add(1,area);
            PageHelper.startPage(page, Page.ok().getPageSize());
            PageInfo<Login_Data> userInfoPage = new PageInfo<Login_Data>(login_dataTableMapper.GetLogin_DataByAddress(address1));
            return R.ok().playCode(200).playMessage("成功").playData("login_data", userInfoPage.getList())
                    .playData("page", page).playData("pages", userInfoPage.getPages()).
                            playData("province",provincelist).
                            playData("city",cityList)
                    .playData("area",list);
        }
        PageInfo<Login_Data> userInfoPage = new PageInfo<Login_Data>(login_dataTableMapper.GetLogin_DataByAddress(address));
        return R.ok().playCode(200).playMessage("成功").playData("login_data", userInfoPage.getList())
                .playData("page", page).playData("pages", userInfoPage.getPages());
    }

    @Override
    public R GetLogin_DataByAddressNowDay(String address,int page) {
        PageHelper.startPage(page, Page.ok().getPageSize());
        PageInfo<Login_Data> userInfoPage = new PageInfo<Login_Data>(login_dataTableMapper.GetLogin_DataByAddressNowDay("%" + address + "%"));
        return R.ok().playCode(200).playMessage("成功").playData("login_data", userInfoPage.getList())
                .playData("page", page).playData("pages", userInfoPage.getPages());
    }

    @Override
    public R GetLogin_DataByAddressSevenDay(String address,int page) {
        PageHelper.startPage(page, Page.ok().getPageSize());
        PageInfo<Login_Data> userInfoPage = new PageInfo<Login_Data>(login_dataTableMapper.GetLogin_DataByAddressSevenDay("%" + address + "%"));
        return R.ok().playCode(200).playMessage("成功").playData("login_data", userInfoPage.getList())
                .playData("page", page).playData("pages", userInfoPage.getPages());
    }

    @Override
    public R GetLogin_DataByAddressOneMonth(String address,int page) {
        PageHelper.startPage(page, Page.ok().getPageSize());
        PageInfo<Login_Data> userInfoPage = new PageInfo<Login_Data>(login_dataTableMapper.GetLogin_DataByAddressOneMonth("%" + address + "%"));
        return R.ok().playCode(200).playMessage("成功").playData("login_data", userInfoPage.getList())
                .playData("page", page).playData("pages", userInfoPage.getPages());
    }

    @Override
    public R GetLogin_NumByAddress(List<Province> citys) {
        List<city> cities=new ArrayList<>();
        for (Province province : citys) {
            String provinceName = province.getProvinceName();
            for (city city1 : province.getCitysName()) {
                String cityName=city1.getName();
                city city=new city();
                city.setName(cityName);
                city.setValue(login_dataTableMapper.GetLogin_NumByAddress("%" + provinceName + "%" + cityName + "%"));
                cities.add(city);
            }
        }
        return R.ok().playCode(200).playMessage("成功").playData("city", cities);
    }

    @Override
    public R GetLogin_NumByAddressAndProvince(List<Province> citys) {
        List<city> cities=new ArrayList<>();
        for (Province province : citys) {
            String provinceName = province.getProvinceName();
            for (city city1 : province.getCitysName()) {
                String cityName=city1.getName();
                city city=new city();
                city.setName(cityName);
                city.setValue(login_dataTableMapper.GetLogin_NumByAddress("%" + provinceName + "%" + cityName + "%"));
                cities.add(city);
            }
        }
        List<city> cities1=cities.stream().sorted((x,y)->y.getValue()-x.getValue()).limit(5).collect(Collectors.toList());
        System.out.println(cities1);
        return R.ok().playCode(200).playMessage("成功").playData("city", cities).playData("top",cities1).playData("province",citys.get(0).getProvinceName());
    }

    @Override
    public R GetLogin_NumByAddressNowDay(List<Province> citys) {
       List<city> cities=new ArrayList<>();
        for (Province province : citys) {
            String provinceName = province.getProvinceName();
            for (city city1 : province.getCitysName()) {
                String cityName=city1.getName();
                city city=new city();
                city.setName(cityName);
                city.setValue(login_dataTableMapper.GetLogin_NumByAddressNowDay("%" + provinceName + "%" + cityName + "%"));
                cities.add(city);
            }
        }
        return R.ok().playCode(200).playMessage("成功").playData("city", cities);
    }

    @Override
    public R GetLogin_NumByAddressSevenDay(List<Province> citys) {
        List<city> cities=new ArrayList<>();
        for (Province province : citys) {
            String provinceName = province.getProvinceName();
            for (city city1 : province.getCitysName()) {
                String cityName=city1.getName();
                city city=new city();
                city.setName(cityName);
                city.setValue(login_dataTableMapper.GetLogin_NumByAddressSevenDay("%" + provinceName + "%" + cityName + "%"));
                cities.add(city);
            }
        }
        return R.ok().playCode(200).playMessage("成功").playData("city", cities);
    }

    @Override
    public R GetLogin_NumByAddressOneMonth(List<Province> citys) {
        List<city> cities=new ArrayList<>();
        for (Province province : citys) {
            String provinceName = province.getProvinceName();
            for (city city1 : province.getCitysName()) {
                String cityName=city1.getName();
                city city=new city();
                city.setName(cityName);
                city.setValue(login_dataTableMapper.GetLogin_NumByAddressOneMonth("%" + provinceName + "%" + cityName + "%"));
                cities.add(city);
            }
        }
        return R.ok().playCode(200).playMessage("成功").playData("city", cities);
    }

    @Override
    public R DeleteLogin_DataByThreeMonth() {
        return R.ok().playCode(200).playMessage("成功").playData("login_data", login_dataTableMapper.DeleteLogin_DataByThreeMonth());
    }

    @Override
    public R GetPageAll(int page) {
        PageHelper.startPage(page, Page.ok().getPageSize());
        PageInfo<Login_Data> userInfoPage = new PageInfo<Login_Data>(login_dataTableMapper.GetLogin_DataAll());
        return R.ok().playCode(200).playMessage("成功").playData("login_data", userInfoPage.getList())
                .playData("page", page).playData("pages", userInfoPage.getPages());
    }
}

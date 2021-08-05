package com.ithujiaze.test;

import com.itchenyang.result.R;
import com.ithujiaze.dao.AreaTableMapper;
import com.ithujiaze.dao.CityTableMapper;
import com.ithujiaze.dao.ProvinceTableMapper;
import com.ithujiaze.dao.UserTableMapper;
import com.ithujiaze.entity.Point;
import com.ithujiaze.entity.Province;
import com.ithujiaze.service.CityService;
import com.ithujiaze.service.Login_DataService;
import com.ithujiaze.untils.NetworkUtil;
import com.sun.xml.internal.ws.api.ha.StickyFeature;
import org.apache.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class test {
    @Autowired
    private UserTableMapper userTableMapper;
    @Autowired
    private CityTableMapper cityTableMapper;
    @Autowired
    private Login_DataService login_dataService;

    @Autowired
    private ProvinceTableMapper provinceTableMapper;
    @Autowired
    private AreaTableMapper areaTableMapper;
    @GetMapping("/test")
    public R test(HttpServletRequest request){
        String[] string = {"呼和浩特","呼伦贝尔","通辽","赤峰","巴彦淖尔","乌兰察布","包头","鄂尔多斯","乌海"};

        for(int i=0;i<string.length;i++) {
            Map<String,String> map = new HashMap<>();
            map.put("name",string[i]);
            map.put("pid","26");
            cityTableMapper.insertCity(map);
        }
//        for (int i=1;i<string.length;i++){
//        map.put("area_name",string[i]);
//        map.put("city_id","2");
//        cityTableMapper.insertCity(map);
//        }
//     Point point=login_dataService.login("mac1","115.236.55.101","11");
        return R.ok().playData("data","11");
    }
}

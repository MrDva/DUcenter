package com.ithujiaze.test;

import com.itchenyang.result.R;
import com.ithujiaze.dao.UserTableMapper;
import com.ithujiaze.entity.Point;
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
    private Login_DataService login_dataService;
    @GetMapping("/test")
    public R test(HttpServletRequest request){
     Point point=login_dataService.login("mac1","115.236.55.101","11");
        return R.ok().playData("data","");
    }
}

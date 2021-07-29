package com.ithujiaze.test;

import com.itchenyang.result.R;
import com.ithujiaze.dao.UserTableMapper;
import com.sun.xml.internal.ws.api.ha.StickyFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class test {
    @Autowired
    private UserTableMapper userTableMapper;
    @GetMapping("/test")
    public R test(){
        Map<String,String> map=new HashMap<>();
        map.put("phone","1");
        map.put("password","1");
        return R.ok().playData("data",userTableMapper.GetUserByUserId(map));
    }
}

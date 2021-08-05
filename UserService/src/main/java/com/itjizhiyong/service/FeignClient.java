package com.itjizhiyong.service;

import com.itchenyang.result.R;
import com.ithujiaze.entity.Login_Data;
import com.ithujiaze.entity.Point;
import com.itjizhiyong.entities.FeignArg;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@Service
@org.springframework.cloud.openfeign.FeignClient(name = "service")
public interface FeignClient {
    //注意调用者和被调用者之间必须用相同的PostMapping
    @PostMapping(value = "/Login_Data/Login",consumes = "application/json")
//    Point isAbnormal(@RequestParam("mac") String mac, @RequestParam("ip") String ip, @RequestParam("phone") String phone);
    Point isAbnormal(@RequestBody FeignArg feignArg);
    @GetMapping(value = "/City/GetAllCity",consumes = "application/json")
    R isGetAllCity(@RequestParam("address") String address);
    @PostMapping(value = "/faceId")
     boolean isFace(@RequestBody Map<String,Object> map);

}

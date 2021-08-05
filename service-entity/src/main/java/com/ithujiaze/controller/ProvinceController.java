package com.ithujiaze.controller;

import com.itchenyang.result.R;
import com.ithujiaze.entity.Province;
import com.ithujiaze.service.ProvinceTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Province")
@CrossOrigin(origins = "*")
public class ProvinceController {
    @Autowired
    private ProvinceTableService provinceTableService;
    @GetMapping("/GetCityByP")
    public R GetCityByP(@RequestParam("address") String name){
        return R.ok().playMessage("成功").playData("province",provinceTableService.GetCityByP(name));
    }

    @GetMapping("/GetCity")
    public R GetCity(){
        return R.ok().playMessage("成功").playData("province",provinceTableService.GetCity());
    }

}

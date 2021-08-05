package com.ithujiaze.controller;

import com.itchenyang.result.R;
import com.ithujiaze.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/City")
@CrossOrigin(origins = "*")
public class CityController {
    @Autowired
    private CityService cityService;
    @GetMapping("/GetCity")
    public R GetCity(){
        return cityService.GetCity();
    }
    @GetMapping("/GetCityByString")
    public R GetCityByString(@RequestParam("address") String name){
        return cityService.GetCityByString(name);
    }
    @PostMapping("/insertCity")
    public R insertCity(@RequestBody Map<String,String> map){
        return cityService.insertCity(map);
    }
}

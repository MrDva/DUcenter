package com.ithujiaze.controller;

import com.itchenyang.result.R;
import com.ithujiaze.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/Area")
@CrossOrigin(origins = "*")
public class AreaController {
    @Autowired
    private AreaService areaService;
    @GetMapping("/GetAreaByCity")
    public R GetAreaByCity(@RequestParam("id") int id){
        return areaService.GetAreaByCity(id);
    }
    @GetMapping("/GetAreaByCityName")
    public  R GetAreaByCity(@RequestParam("address") String name){
        return areaService.GetAreaByCity(name);
    }
    @PostMapping("/insertArea")
    public R insertArea(@RequestBody Map<String, String> map){
        return  areaService.insertArea(map);
    }

}

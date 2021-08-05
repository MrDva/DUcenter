package com.ithujiaze.controller;

import com.itchenyang.result.R;
import com.ithujiaze.entity.Login_Data;
import com.ithujiaze.entity.Province;
import com.ithujiaze.service.Login_DataService;
import com.ithujiaze.service.ProvinceTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Login_Data")
@CrossOrigin(origins = "*")
public class Login_DataController {
    @Autowired
    private Login_DataService login_dataService;

    @Autowired
    private ProvinceTableService provinceTableService;

    @GetMapping("/GetLogin_DataAll")
    public R GetLogin_DataAll(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control", "no-cache");
        return login_dataService.GetLogin_DataAll();
    }

    @GetMapping("/GetLogin_DataById")

    public R GetLogin_DataById(@RequestParam("id") int id,HttpServletResponse response) {
        return login_dataService.GetLogin_DataById(id);
    }

//    @GetMapping("/GetLogin_DataByIdAndPage")
//    public R GetLogin_DataByIdAndPage(@RequestParam("id") int id,@RequestParam("page") int page) {
//        return login_dataService.GetLogin_DataByIdAndPage(id,page);
//    }

    @GetMapping("/GetLogin_DataByIdNowDay")
    public R GetLogin_DataByIdNowDay(@RequestParam("id") int id) {
        return login_dataService.GetLogin_DataByIdNowDay(id);
    }

    @GetMapping("/GetLogin_DataByIdSevenDay")
    public R GetLogin_DataByIdSevenDay(@RequestParam("id") int id) {
        return login_dataService.GetLogin_DataByIdSevenDay(id);
    }

    @GetMapping("/GetLogin_DataByIdOneMonth")
    public R GetLogin_DataByIdOneMonth(@RequestParam("id") int id) {
        return login_dataService.GetLogin_DataByIdOneMonth(id);
    }

    @PostMapping("/Insert")
    public R Insert(@RequestBody Login_Data login_data) {
        return login_dataService.Insert(login_data);
    }

    @GetMapping("/GetLogin_DataByAddress_one")
    public R GetLogin_DataByAddress_one(@RequestParam("address") String address,@RequestParam("page") int page) {
        address=address.replace(";","%");
        return login_dataService.GetLogin_DataByAddress_one(address,page);
    }

    @GetMapping("/GetLogin_DataByAddress")
    public R GetLogin_DataByAddress(@RequestParam("address") String address,@RequestParam("page") int page) {
        address=address.replace(";","%");
        return login_dataService.GetLogin_DataByAddress_one(address,page);
    }

    @GetMapping("/GetLogin_DataByAddressNowDay")
    public R GetLogin_DataByAddressNowDay(@RequestParam("address") String address,@RequestParam("page") int page) {
        address=address.replace(";","%");
        return login_dataService.GetLogin_DataByAddressNowDay(address,page);
    }

    @GetMapping("/GetLogin_DataByAddressSevenDay")
    public R GetLogin_DataByAddressSevenDay(@RequestParam("address") String address,@RequestParam("page") int page) {
        address=address.replace(";","%");
        return login_dataService.GetLogin_DataByAddressSevenDay(address,page);
    }

    @GetMapping("/GetLogin_DataByAddressOneMonth")
    public R GetLogin_DataByAddressOneMonth(@RequestParam("address") String address,@RequestParam("page") int page) {
        address=address.replace(";","%");
        return login_dataService.GetLogin_DataByAddressOneMonth(address,page);
    }

    @GetMapping("/GetLogin_NumByAddressAndProvince")
    public R GetLogin_NumByAddressAndProvince(@RequestParam(value = "address") String address, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control", "no-cache");
        return login_dataService.GetLogin_NumByAddressAndProvince(provinceTableService.GetCityByP(address));
    }

    @GetMapping("/GetLogin_NumByAddress")
    public R GetLogin_NumByAddress(@RequestParam(value = "address", required = false) String address, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control", "no-cache");
        if (address == null) {
            return login_dataService.GetLogin_NumByAddress(provinceTableService.GetCity());
        } else {
            return login_dataService.GetLogin_NumByAddress(provinceTableService.GetCityByP(address));
        }

    }

    @GetMapping("/GetLogin_NumByAddressNowDay")
    public R GetLogin_NumByAddressNowDay(@RequestParam(value = "address", required = false) String address, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control", "no-cache");
        if (address == null) {
            return login_dataService.GetLogin_NumByAddressNowDay(provinceTableService.GetCity());
        } else {
            return login_dataService.GetLogin_NumByAddressNowDay(provinceTableService.GetCityByP(address));
        }
    }

    @GetMapping("/GetLogin_NumByAddressSevenDay")
    public R GetLogin_NumByAddressSevenDay(@RequestParam(value = "address", required = false) String address, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control", "no-cache");
        if (address == null) {
            return login_dataService.GetLogin_NumByAddressSevenDay(provinceTableService.GetCity());
        } else {
            return login_dataService.GetLogin_NumByAddressSevenDay(provinceTableService.GetCityByP(address));
        }
    }

    @GetMapping("/GetLogin_NumByAddressOneMonth")
    public R GetLogin_NumByAddressOneMonth(@RequestParam(value = "address", required = false) String address, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control", "no-cache");
        if (address == null) {
            return login_dataService.GetLogin_NumByAddressOneMonth(provinceTableService.GetCity());
        } else {
            return login_dataService.GetLogin_NumByAddressOneMonth(provinceTableService.GetCityByP(address));
        }
    }

    @DeleteMapping("/DeleteLogin_DataByThreeMonth")
    public R DeleteLogin_DataByThreeMonth() {
        return login_dataService.DeleteLogin_DataByThreeMonth();
    }

    @GetMapping("/GetPageAll")
    public R GetPageAll(@RequestParam("page") int page) {
        return login_dataService.GetPageAll(page);
    }
}

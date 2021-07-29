package com.ithujiaze.controller;

import com.itchenyang.result.R;
import com.ithujiaze.entity.Login_Data;
import com.ithujiaze.entity.Province;
import com.ithujiaze.service.Login_DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Login_Data")
public class Login_DataController {
    @Autowired
    private Login_DataService login_dataService;

    @GetMapping("/GetLogin_DataById")
    public R GetLogin_DataById(@RequestParam("id") int id) {
        return login_dataService.GetLogin_DataById(id);
    }

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

    @GetMapping("/GetLogin_DataByAddress")
    public R GetLogin_DataByAddress(@RequestParam("address") String address) {
        return login_dataService.GetLogin_DataByAddress(address);
    }

    @GetMapping("/GetLogin_DataByAddressNowDay")
    public R GetLogin_DataByAddressNowDay(@RequestParam("address") String address) {
        return login_dataService.GetLogin_DataByAddressNowDay(address);
    }

    @GetMapping("/GetLogin_DataByAddressSevenDay")
    public R GetLogin_DataByAddressSevenDay(@RequestParam("address") String address) {
        return login_dataService.GetLogin_DataByAddressSevenDay(address);
    }

    @GetMapping("/GetLogin_DataByAddressOneMonth")
    public R GetLogin_DataByAddressOneMonth(@RequestParam("address") String address) {
        return login_dataService.GetLogin_DataByAddressOneMonth(address);
    }


    @GetMapping("/GetLogin_NumByAddress")
    public R GetLogin_NumByAddress(@RequestBody List<Province> provinces) {
        return login_dataService.GetLogin_NumByAddress(provinces);
    }

    @GetMapping("/GetLogin_NumByAddressNowDay")
    public R GetLogin_NumByAddressNowDay(@RequestBody List<Province> provinces) {
        return login_dataService.GetLogin_NumByAddressNowDay(provinces);
    }

    @GetMapping("/GetLogin_NumByAddressSevenDay")
    public R GetLogin_NumByAddressSevenDay(@RequestBody List<Province> provinces) {
        return login_dataService.GetLogin_NumByAddress(provinces);
    }

    @GetMapping("/GetLogin_NumByAddressOneMonth")
    public R GetLogin_NumByAddressOneMonth(@RequestBody List<Province> provinces) {
        return login_dataService.GetLogin_NumByAddress(provinces);
    }

    @DeleteMapping("/DeleteLogin_DataByThreeMonth")
    public R DeleteLogin_DataByThreeMonth() {
        return login_dataService.DeleteLogin_DataByThreeMonth();
    }

}

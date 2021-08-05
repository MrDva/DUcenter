package com.ithujiaze.controller;

import com.itchenyang.result.R;
import com.ithujiaze.entity.Three_Data;
import com.ithujiaze.service.Three_DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Three_Data")
@CrossOrigin(origins = "*")
public class Three_DataController {
    @Autowired
    private Three_DataService three_dataService;

    @RequestMapping("/GetThree_DataById")
    public R GetThree_DataById(@RequestParam("id") int id) {
        return three_dataService.GetThree_DataById(id);
    }

    @GetMapping("/GetThree_DataByIdGroupByCount")
    public R GetThree_DataByIdGroupByCount(@RequestParam("id") int id) {
        return three_dataService.GetThree_DataByIdGroupByCount(id);

    }

    @PostMapping("/insert")
    public R insert(@RequestBody Three_Data three_data) {
        return three_dataService.insert(three_data);
    }

    @GetMapping("/GetThree_DataByAddress")
    public R GetThree_DataByAddress(@RequestParam("address") String address) {
        return three_dataService.GetThree_DataByAddress(address);
    }

    @GetMapping("/GetThree_DataByAddressNowDay")
    public R GetThree_DataByAddressNowDay(@RequestParam("address") String address) {
        return three_dataService.GetThree_DataByAddressNowDay(address);
    }

    @GetMapping("/GetThree_DataByAddressSevenDay")
    public R GetThree_DataByAddressSevenDay(@RequestParam("address") String address) {
        return three_dataService.GetThree_DataByAddressSevenDay(address);
    }

    @GetMapping("/GetThree_DataByAddressOneMonth")
    public R GetThree_DataByAddressOneMonth(@RequestParam("address") String address) {
        return three_dataService.GetThree_DataByAddressOneMonth(address);
    }

    @GetMapping("/DeleteThree_DataByThreeMonth")
    public R DeleteThree_DataByThreeMonth() {
        return three_dataService.DeleteThree_DataByThreeMonth();
    }
}

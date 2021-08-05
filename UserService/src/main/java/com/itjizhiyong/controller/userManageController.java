package com.itjizhiyong.controller;

import com.alibaba.fastjson.JSONObject;
import com.itchenyang.result.R;
import com.itjizhiyong.entities.User;
import com.itjizhiyong.service.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Manage")
@CrossOrigin(origins = "*")
public class userManageController {
    @Autowired
    private Login loginServ;

    @PostMapping("/updateUser")
    public boolean updateUser(@RequestBody String userJson) {
        JSONObject UserJson = JSONObject.parseObject(userJson);
        int userId = Integer.parseInt(UserJson.getString("Id"));
        String password = UserJson.getString("Password");
        String affiliation = UserJson.getString("Affiliation");
        String username = UserJson.getString("Username");
        String phone = UserJson.getString("Phone");
        int role_Id = (int) UserJson.getInteger("Role_Id");
//        int user_ID =(int) UserJson.getInteger("User_Id");


        User user = new User();
        user.setPhone(phone);
        user.setUser_Id(userId);
        user.setUsername(username);
        user.setAffiliation(affiliation);
        user.setPassword(password);
        user.setRole_Id(role_Id);

        loginServ.UserUpdate(user);
        return true;
    }

    @PostMapping("/addUser")
    public boolean addUser(@RequestBody String userJson) {
        JSONObject UserJson = JSONObject.parseObject(userJson);
        String password = UserJson.getString("Password");
        String affiliation = UserJson.getString("Affiliation");
        String username = UserJson.getString("Username");
        String phone = UserJson.getString("Phone");
        int role_Id = (int) UserJson.getInteger("Role_Id");
//        int user_ID =(int) UserJson.getInteger("User_Id");


        User user = new User();
        user.setPhone(phone);

        user.setUsername(username);
        user.setAffiliation(affiliation);
        user.setPassword(password);
        user.setRole_Id(role_Id);

        loginServ.UserAdd(user);
        return true;
    }

    @GetMapping("/getUser")
    public R getUser(@RequestParam("page") int page,
                     @RequestParam("address") String address) {
        address = address.replace(";", "%");
        return loginServ.GetUserByAddress(address, page);
    }
    @GetMapping("/editUser")
    public  R editUser(@RequestParam("id") int id,
                       @RequestParam("address") String address){
        return loginServ.editUser(id,address);
    }
    @GetMapping("/deleteUserById")
    public R deleteUser(@RequestParam("user_Id") int user_Id,
                        @RequestParam("page") int page,
                        @RequestParam("address") String address) {
        loginServ.UserDelete(user_Id);
        address=address.replace(";","");
        return loginServ.GetUserByAddress(address, page);
    }
}

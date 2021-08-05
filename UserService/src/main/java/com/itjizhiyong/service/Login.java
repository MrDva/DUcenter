package com.itjizhiyong.service;

import com.itchenyang.result.R;
import com.itjizhiyong.entities.LoginNum;
import com.itjizhiyong.entities.User;

import java.util.List;

public interface Login {
    List<LoginNum> login(String Phone, String Password);
    void UserAdd(User user);
    void UserDelete(int user_Id);
    void UserUpdate(User user);
    public R GetUserByAddress(String address,int page);
    public R editUser(int id,String address);
}

package com.itjizhiyong.service;

import com.itchenyang.result.R;
import com.itjizhiyong.entities.LoginNum;
import com.itjizhiyong.entities.MyR;

import java.util.List;
import java.util.Map;

public interface UserService {
//    public Map<String,Object> login(String username, String password);

      public MyR login(String Phone, String Password, String mac, String ip);
      //人脸验证功能
      public MyR face(String phone,String password,String mac,String ip,String face);
}

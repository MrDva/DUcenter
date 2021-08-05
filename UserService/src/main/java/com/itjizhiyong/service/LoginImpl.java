package com.itjizhiyong.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itchenyang.result.R;
import com.itjizhiyong.entities.LoginNum;
import com.itjizhiyong.entities.User;
import com.itjizhiyong.mapper.RoleTableMapper;
import com.itjizhiyong.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LoginImpl implements Login{
    Map<String,String> loginMap = new HashMap<>();
    @Autowired
    private LoginMapper loginmapper;
    @Autowired
    private  FeignClient feignClient;
    @Autowired
    private RoleTableMapper roleTableMapper;
    @Override
    public List<LoginNum> login(String Phone, String Password) {
        loginMap.put("Phone",Phone);
        loginMap.put("Password",Password);
        List<LoginNum> LoginRes = loginmapper.GetUser(loginMap);
        return LoginRes;

    }

    @Override
    public void UserAdd(User user) {
        loginmapper.UserAdd(user);
    }

    @Override
    public void UserDelete(int user_Id) {
        loginmapper.UserDelete(user_Id);
    }

    @Override
    public void UserUpdate(User user) {
        loginmapper.UserUpdate(user);
    }

    @Override
    public R GetUserByAddress(String address,int page) {
        PageHelper.startPage(page,8);
        PageInfo<User> userInfoPage = new PageInfo<User>(loginmapper.GetUserByAddress("%"+address+"%"));
        return R.ok().playCode(200).playMessage("成功").playData("users",userInfoPage.getList()).playData("page",page).
                playData("pages",userInfoPage.getPages());
    }

    @Override
    public R editUser(int id,String address) {
       R r= feignClient.isGetAllCity(address);
        return r.playData("user",loginmapper.getUserById(id)).
                playData("role",roleTableMapper.GetRoleALl());
    }
}

package com.itjizhiyong.mapper;

import com.itjizhiyong.entities.LoginNum;
import com.itjizhiyong.entities.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
@Mapper
public interface LoginMapper {

//    public LoginNum GetUser(Map<String,String> map);
    public List<LoginNum> GetUser(Map<String,String> map);
    public void UserAdd(User user);
    public void UserDelete(int User_Id);
    void UserUpdate(User user);
    public List<User> GetUserByAddress(String address);
    public User getUserById(int id);

}

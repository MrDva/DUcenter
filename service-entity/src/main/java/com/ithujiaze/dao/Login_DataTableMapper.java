package com.ithujiaze.dao;

import com.ithujiaze.entity.Login_Data;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface Login_DataTableMapper {
    public List<Login_Data> GetLogin_DataById(int id);

    public List<Login_Data> GetLogin_DataAll();

    public Login_Data GetLogin_DataByPhoneNew(String phone);

    public List<Login_Data> GetLogin_DataByIdNowDay(int id);

    public List<Login_Data> GetLogin_DataByIdSevenDay(int id);

    public List<Login_Data> GetLogin_DataByIdOneMonth(int id);

    public int Insert(Login_Data login_data);

    public List<Login_Data> GetLogin_DataByAddress(String address);

    public List<Login_Data> GetLogin_DataByAddressNowDay(String address);

    public List<Login_Data> GetLogin_DataByAddressSevenDay(String address);

    public List<Login_Data> GetLogin_DataByAddressOneMonth(String address);

    public int GetLogin_NumByAddress(String address);

    public int GetLogin_NumByAddressNowDay(String address);

    public int GetLogin_NumByAddressSevenDay(String address);

    public int GetLogin_NumByAddressOneMonth(String address);

    public int DeleteLogin_DataByThreeMonth();
}

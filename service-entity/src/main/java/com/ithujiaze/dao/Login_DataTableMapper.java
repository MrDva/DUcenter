package com.ithujiaze.dao;

import com.ithujiaze.entity.Login_Data;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface Login_DataTableMapper {
    public Login_Data GetLogin_DataById(int id);
    public  void insert(Login_Data login_data);
}

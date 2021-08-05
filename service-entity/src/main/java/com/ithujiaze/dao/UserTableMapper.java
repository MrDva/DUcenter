package com.ithujiaze.dao;

import com.ithujiaze.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper
@Repository
public interface UserTableMapper {
    public User GetUserByUserId(Map<String,String> map);

    public User GetUserByUserId2(int id);
}
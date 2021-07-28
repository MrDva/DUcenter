package com.ithujiaze.dao;

import com.ithujiaze.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserTableMapper {
    public User GetUserByUserId(int id);
    public User GetUserByUserId2(int id);
}
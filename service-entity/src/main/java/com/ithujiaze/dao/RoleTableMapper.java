package com.ithujiaze.dao;

import com.ithujiaze.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RoleTableMapper {
    public Role GetRoleById(int id);
}

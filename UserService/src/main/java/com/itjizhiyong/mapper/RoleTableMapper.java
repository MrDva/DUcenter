package com.itjizhiyong.mapper;

import com.itjizhiyong.entities.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface RoleTableMapper {
    public List<Role> GetRoleById(int id);
    public int UpdateRoleById(Role role);
    public  int DeleteRoleById(int id);
    public int   InsertRoleId(Role role);
    public  List<Role> GetRoleALl();
}

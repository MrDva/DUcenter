package com.itjizhiyong.service;

import com.itchenyang.result.R;
import com.itjizhiyong.entities.Role;

import java.util.List;

public interface RoleService {
    public R GetRoleById(int id);
    public R UpdateRoleById(String name,List<String> list,String id);
    public  R DeleteRoleById(int id);
    public R   InsertRoleId(Role role);
    public R GetRoleALl();
}

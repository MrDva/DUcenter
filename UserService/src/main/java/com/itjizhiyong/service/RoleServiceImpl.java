package com.itjizhiyong.service;

import com.itchenyang.result.R;
import com.itjizhiyong.entities.Role;
import com.itjizhiyong.entities.Role_Authority;
import com.itjizhiyong.mapper.RoleTableMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl implements  RoleService{
    @Autowired
    private RoleTableMapper roleTableMapper;
    @Autowired
    private Role_AuthorityService role_authorityService;
    @Override
    public R GetRoleById(int id) {
        return R.ok().playCode(200).playData("role",roleTableMapper.GetRoleById(id));
    }

    @Override
    public R UpdateRoleById(String name, List<String> list,String id) {
        Role role=new Role();
        role.setRole_Id(Integer.parseInt(id));
        role.setRole_Name(name);
        List<Role_Authority> list1=new ArrayList<>();
        for (String item:list) {
            Role_Authority role_authority=new Role_Authority();
            role_authority.setRole_Id(Integer.parseInt(id));
            role_authority.setAuthority_Id(Integer.parseInt(item));
            list1.add(role_authority);
        }
        role_authorityService.DeleteAllByRoleId(Integer.parseInt(id));
        return R.ok().playCode(200).playData("num",roleTableMapper.UpdateRoleById(role)).
                playData("num2",role_authorityService.UpdateByRoleId(list1));
    }

    @Override
    public R DeleteRoleById(int id) {
        return R.ok().playCode(200).playData("num",roleTableMapper.DeleteRoleById(id));
    }

    @Override
    public R InsertRoleId(Role role) {
        return R.ok().playCode(200).playData("num",roleTableMapper.InsertRoleId(role));
    }

    @Override
    public R GetRoleALl() {
        return R.ok().playCode(200).playData("roles",roleTableMapper.GetRoleALl());
    }
}

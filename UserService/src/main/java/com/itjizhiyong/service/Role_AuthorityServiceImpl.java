package com.itjizhiyong.service;

import com.itchenyang.result.R;
import com.itjizhiyong.entities.Role_Authority;
import com.itjizhiyong.service.Role_AuthorityService;
import com.itjizhiyong.mapper.Role_AuthorityTableMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Role_AuthorityServiceImpl implements Role_AuthorityService {
    @Autowired
    private Role_AuthorityTableMapper role_authorityTableMapper;

    @Override
    public R DeleteAllByRoleId(int role_id) {
        return R.ok().playCode(200).playMessage("成功").playData("nums",role_authorityTableMapper.DeleteAllByRoleId(role_id));
    }

    @Override
    public R InsertAllByRoleId(List<Role_Authority> role_authorities) {
        return R.ok().playCode(200).playMessage("成功").playData("nums",role_authorityTableMapper.InsertAllByRoleId(role_authorities));
    }

    @Override
    public R UpdateByRoleId(List<Role_Authority> role_authorities) {
        DeleteAllByRoleId(role_authorities.get(0).getRole_Id());
        return InsertAllByRoleId(role_authorities);
    }
}

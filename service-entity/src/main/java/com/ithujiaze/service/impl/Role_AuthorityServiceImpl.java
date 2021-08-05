package com.ithujiaze.service.impl;

import com.itchenyang.result.R;
import com.ithujiaze.dao.Role_AuthorityTableMapper;
import com.ithujiaze.entity.Role_Authority;
import com.ithujiaze.service.Role_AuthorityService;
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
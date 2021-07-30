package com.ithujiaze.service;

import com.itchenyang.result.R;
import com.ithujiaze.entity.Role_Authority;

import java.util.List;

public interface Role_AuthorityService {
    public R DeleteAllByRoleId(int role_id);

    public R InsertAllByRoleId(List<Role_Authority> role_authorities);

    public R UpdateByRoleId(List<Role_Authority> role_authorities);
}

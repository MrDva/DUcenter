package com.itjizhiyong.service;

import com.itchenyang.result.R;
import com.itjizhiyong.entities.Authority;

import java.util.List;

public interface AuthorityService {
    public R GetAuthorityById(int id);

    public R InsertAuthority(Authority authority);

    public R GetAuthorityByRoleId(int id);

    public R GetAuthorityAll();

    public R DeleteAuthorityById(int id);

//    public R GetPage(int page);

    public R UpdateAuthorityById(Authority authority);

}

package com.ithujiaze.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itchenyang.result.R;
import com.ithujiaze.dao.AuthorityTableMapper;
import com.ithujiaze.entity.Authority;
import com.ithujiaze.entity.Page;
import com.ithujiaze.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorityServiceImpl implements AuthorityService {
    @Autowired
    private AuthorityTableMapper authorityTableMapper;

    @Override
    public R GetAuthorityById(int id) {
        return R.ok().playCode(200).playMessage("成功").playData("authority", authorityTableMapper.GetAuthorityById(id));
    }

    @Override
    public R InsertAuthority(Authority authority) {
        return R.ok().playCode(200).playMessage("成功").playData("num", authorityTableMapper.InsertAuthority(authority));
    }

    @Override
    public R GetAuthorityAll() {
        return R.ok().playCode(200).playMessage("成功").playData("authority",authorityTableMapper.GetAuthorityAll());
    }

    @Override
    public R DeleteAuthorityById(int id) {
        return R.ok().playCode(200).playMessage("成功").playData("num", authorityTableMapper.DeleteAuthorityById(id));
    }

    @Override
    public R GetPage(int page) {
        PageHelper.startPage(page, Page.ok().getPageSize());
        PageInfo<Authority> userInfoPage = new PageInfo<Authority>(authorityTableMapper.GetAuthorityAll());
        return R.ok().playCode(200).playMessage("成功").playData("authority",userInfoPage.getList())
                .playData("page",page).playData("pages",userInfoPage.getPages());
    }

    @Override
    public R UpdateAuthorityById(Authority authority) {
        return R.ok().playCode(200).playMessage("成功").playData("num", authorityTableMapper.UpdateAuthorityById(authority));
    }
}

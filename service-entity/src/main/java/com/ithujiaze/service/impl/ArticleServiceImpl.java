package com.ithujiaze.service.impl;

import com.ithujiaze.dao.*;
import com.ithujiaze.entity.Authority;
import com.ithujiaze.entity.Login_Data;
import com.ithujiaze.entity.User;
import com.ithujiaze.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;


@Service
public class ArticleServiceImpl implements ArticleService {


    @Autowired
    private AuthorityTableMapper authorityTableMapper;
    @Autowired
    private UserTableMapper userTableMapper;
    @Autowired
    private Three_DataTableMapper three_dataTableMapper;
    @Autowired
    private RoleTableMapper roleTableMapper;
    @Autowired
    private Login_DataTableMapper login_dataTableMapper;

    @Override
    public Authority getOneById(Integer id)
    {
        User user=new User();
        user.setUser_Id(1);
        user.setPhone("12");
        Login_Data login_data=new Login_Data();
        java.util.Date date=new java.util.Date();
        Timestamp sqlDate = new Timestamp(date.getTime());
        login_data.setUser(user);
        login_data.setMac("mac2");
        login_data.setAddress("shanghai");
        login_data.setPoint_X("101.0");
        login_data.setPoint_Y("200");
        login_data.setDatetime(sqlDate);
        System.out.println(login_data);
        login_dataTableMapper.insert(login_data);
        System.out.println(userTableMapper.GetUserByUserId(1));
        System.out.println(userTableMapper.GetUserByUserId2(1));
        System.out.println(three_dataTableMapper.GetThree_DataById(1));
        System.out.println(roleTableMapper.GetRoleById(1));
        System.out.println(login_dataTableMapper.GetLogin_DataById(1));
        System.out.println(authorityTableMapper.GetAuthorityById(id));
        return authorityTableMapper.GetAuthorityById(id);
    }


}

package com.ithujiaze.service.impl;

import com.ithujiaze.dao.AuthorityTableMapper;
import com.ithujiaze.entity.Authority;
import com.ithujiaze.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ArticleServiceImpl implements ArticleService {


    @Autowired
    private AuthorityTableMapper authorityTableMapper;



    @Override
    public Authority getOneById(Integer id)
    {
        System.out.println(authorityTableMapper.GetAuthorityById(id));
        return authorityTableMapper.GetAuthorityById(id);
    }


}

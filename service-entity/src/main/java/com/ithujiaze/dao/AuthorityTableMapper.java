package com.ithujiaze.dao;

import com.ithujiaze.entity.Authority;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AuthorityTableMapper {
    public Authority GetAuthorityById(int id);

    public int InsertAuthority(Authority authority);

    public List<Authority> GetAuthorityAll();

    public int DeleteAuthorityById(int id);

    public int UpdateAuthorityById(Authority authority);
}

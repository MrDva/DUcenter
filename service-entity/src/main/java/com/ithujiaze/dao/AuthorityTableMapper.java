package com.ithujiaze.dao;

import com.ithujiaze.entity.Authority;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AuthorityTableMapper {
    public Authority GetAuthorityById(int id);
}

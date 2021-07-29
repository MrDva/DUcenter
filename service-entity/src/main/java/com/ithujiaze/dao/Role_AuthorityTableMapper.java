package com.ithujiaze.dao;

import com.ithujiaze.entity.Role_Authority;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface Role_AuthorityTableMapper {
    public int DeleteAllByRoleId(int role_id);

    public int InsertAllByRoleId(List<Role_Authority> role_authorities);

}

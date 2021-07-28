package com.ithujiaze.dao;

import com.ithujiaze.entity.Three_Data;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface Three_DataTableMapper {
    public Three_Data GetThree_DataById(int id );
}

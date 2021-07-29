package com.ithujiaze.dao;

import com.ithujiaze.entity.Three_Data;
import com.ithujiaze.entity.Three_Data;
import com.ithujiaze.entity.Three_DateCount;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface Three_DataTableMapper {
    public List<Three_Data>  GetThree_DataById(int id);

    public List<Three_DateCount> GetThree_DataByIdGroupByCount(int id);

    public int insert(Three_Data three_data);

    public List<Three_Data> GetThree_DataByAddress(String address);

    public List<Three_Data> GetThree_DataByAddressNowDay(String address);

    public List<Three_Data> GetThree_DataByAddressSevenDay(String address);

    public List<Three_Data> GetThree_DataByAddressOneMonth(String address);

    public int DeleteThree_DataByThreeMonth();
}

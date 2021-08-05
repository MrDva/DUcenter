package com.ithujiaze.dao;

import com.ithujiaze.entity.city;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface CityTableMapper {
    public List<city> GetCity();
    public  List<city> GetCityByP(String name);
    public int insertCity(Map<String,String> map);
}

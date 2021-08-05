package com.ithujiaze.dao;

import com.ithujiaze.entity.Province;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProvinceTableMapper {
    public List<Province> GetCityByP(String name);
    public List<Province> GetCity();
    public  List<Province> GetProvinces();
    public int insertP(Province province);
}

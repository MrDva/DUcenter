package com.ithujiaze.dao;

import com.ithujiaze.entity.Area;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface AreaTableMapper {
    public List<Area> GetAreaByCity(int id);

    public List<Area> GetAreaByCityString(String name);

    public int insertArea(Map<String, String> map);
}

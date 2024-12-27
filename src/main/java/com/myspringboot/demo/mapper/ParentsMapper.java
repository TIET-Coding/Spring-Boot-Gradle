package com.myspringboot.demo.mapper;

import com.myspringboot.demo.model.Parents;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
@Mapper
public interface ParentsMapper {

    public List<HashMap<String, Object>> listallparents();
    int saveParents(Parents parents);
    int updateParents(@Param("P_ID") long P_ID, Parents parents);
    int deleteParents(@Param("P_ID") long P_ID);
}

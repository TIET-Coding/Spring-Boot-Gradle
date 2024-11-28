package com.myspringboot.demo.mapper;

import com.myspringboot.demo.model.Master;
import com.myspringboot.demo.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
@Mapper
public interface MasterMapper {
    List<HashMap<String, Object>> Listallmaster();
    int saveMaster(Master master);
    int updateMaster(@Param("id") Long id, Master master);
    int deleteMaster(@Param("id") Long id);
}

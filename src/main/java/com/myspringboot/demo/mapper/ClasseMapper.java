package com.myspringboot.demo.mapper;

import com.myspringboot.demo.model.Classes;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
@Mapper
public interface ClasseMapper {

    public List<HashMap<String, Object>> listallclasses();
    int saveClasses(Classes classes);
    int updateClasses(@Param("CL_ID") long CL_ID, Classes classes);
    int deleteClasses(@Param("CL_ID") long CL_ID);
}

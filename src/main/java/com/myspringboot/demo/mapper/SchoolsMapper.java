package com.myspringboot.demo.mapper;

import com.myspringboot.demo.model.Schools;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
@Mapper
public interface SchoolsMapper {
    public List<HashMap<String, Object>> listallSchools();
    int saveSchools(Schools schools);
    int updateSchools(@Param("SCH_ID") long SCH_ID, Schools schools);
    int deleteSchools(@Param("{SCH_ID}") long SCH_ID);
}

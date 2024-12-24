package com.myspringboot.demo.mapper;

import com.myspringboot.demo.model.Teachers;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
@Mapper
public interface TeachersMapper {
    public List<HashMap<String, Object>> listallTeachers();
    int saveTeacher(Teachers teachers);
    int updateTeacher(@Param("TH_ID") long TH_ID, Teachers teachers);
    int deleteTeacher(@Param("TH_ID") long TH_ID);
}

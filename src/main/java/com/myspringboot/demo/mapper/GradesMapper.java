package com.myspringboot.demo.mapper;

import com.myspringboot.demo.model.Grades;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
@Mapper
public interface GradesMapper {

    public List<HashMap<String, Object>> listAllGrades();
    int saveGrades(Grades grades);
    int updateGrades(@Param("G_ID") long G_ID, Grades grades);
    int deleteGrades(@Param("G_ID") long G_ID);
}

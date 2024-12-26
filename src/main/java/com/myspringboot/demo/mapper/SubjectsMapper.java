package com.myspringboot.demo.mapper;

import com.myspringboot.demo.model.Subjects;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
@Mapper
public interface SubjectsMapper {
    public List<HashMap<String, Object>> listallSubjects();
    int saveSubjects(Subjects subjects);
    int updateSubjects(@Param("SJ_ID") long SJ_ID, Subjects subjects);
    int deleteSubjects(@Param("SJ_ID") long SJ_ID);
}

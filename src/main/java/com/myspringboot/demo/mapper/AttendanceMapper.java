package com.myspringboot.demo.mapper;

import com.myspringboot.demo.model.Attendance;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
@Mapper
public interface AttendanceMapper {
    public List<HashMap<String, Object>> listallAttendance();
    int saveAttendance(Attendance attendance);
    int updateAttendance(@Param("A_ID") long A_ID, Attendance attendance);
    int deleteAttendance(@Param("A_ID") long A_ID);
}

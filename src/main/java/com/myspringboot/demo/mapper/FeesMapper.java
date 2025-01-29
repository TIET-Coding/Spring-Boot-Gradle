package com.myspringboot.demo.mapper;

import com.myspringboot.demo.model.Fees;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
@Mapper
public interface FeesMapper {
    public List<HashMap<String,Object>> listallFees();
    int saveFees(Fees fees);
    int updateFees(@Param("F_ID") long  F_ID,  Fees fees);
    int deleteFees(@Param("F_ID") long F_ID);
}

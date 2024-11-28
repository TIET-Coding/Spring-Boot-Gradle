package com.myspringboot.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface RoleuserMapper {
    List<HashMap<String, Object>> Listallroleuser();
}

package com.myspringboot.demo.mapper;


import com.myspringboot.demo.model.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
@Mapper
public interface RoleMapper {

    public List<HashMap<String, Object>> listallrole();
    int saveroles(Role role);
    int updateroles(@Param("r_id") Long r_id, Role role);
    int deleteroles(@Param("r_id") Long r_id);
}

package com.myspringboot.demo.mapper;

import com.myspringboot.demo.model.Permissions;
import com.myspringboot.demo.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
@Mapper
public interface PermissionsMapper {
    public List<HashMap<String, Object>> Listallpermission();
    int savePermissions(Permissions permissions);
    int updatePermissions(@Param("p_id") Long p_id, Permissions permissions);
    int deletePermissions(@Param("p_id") Long p_id);
}

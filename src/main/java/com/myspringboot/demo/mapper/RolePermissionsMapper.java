package com.myspringboot.demo.mapper;

import com.myspringboot.demo.model.RolePermissions;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
@Mapper
public interface RolePermissionsMapper {

    public List<HashMap<String, Object>> Listallrolepermissions();
    int Saverolepermission(RolePermissions rolePermissions);
    int Updaterolpermission(@Param("role_p_id") long role_p_id, RolePermissions rolePermissions );
    int Deleterolpermission(@Param("role_p_id") long role_p_id);

}

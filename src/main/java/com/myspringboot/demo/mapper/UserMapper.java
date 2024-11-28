package com.myspringboot.demo.mapper;

import com.myspringboot.demo.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.lang.Object;
import java.util.HashMap;
import java.util.List;


@Mapper
public interface UserMapper {
    public List<HashMap<String, Object>> Listalluser();
    int saveUser(User user);
    int updateUser(@Param("user_id") Long user_id, User user);
    int deleteUser(@Param("user_id") Long user_id);

}

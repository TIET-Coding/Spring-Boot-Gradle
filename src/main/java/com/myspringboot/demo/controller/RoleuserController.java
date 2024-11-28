package com.myspringboot.demo.controller;

import com.myspringboot.demo.mapper.RoleuserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping ("/Roleuser")
public class RoleuserController {
    @Autowired
    RoleuserMapper roleuserMapper;

    @GetMapping("/list")
    public Map<String, Object> listallroleuser(){
        List<HashMap<String, Object>> alluser = roleuserMapper.Listallroleuser();
        Map<String, Object> response = new HashMap<>();
        response.put("message","User retrieved successfully");
        response.put("status", "success");
        response.put("data", alluser);

        return response;
    }
}

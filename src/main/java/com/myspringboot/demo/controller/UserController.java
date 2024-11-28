package com.myspringboot.demo.controller;

import com.myspringboot.demo.mapper.UserMapper;
import com.myspringboot.demo.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.Object;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Users")
public class UserController {
    @Autowired
    UserMapper userMapper;
// List User
    @GetMapping ("/list")
    public Map<String, Object> listuser(){
        List<HashMap<String, Object>> alluser = userMapper.Listalluser();
        Map<String, Object> response = new HashMap<>();
        response.put("message","User retrieved successfully");
        response.put("status", "success");
        response.put("data", alluser);

        return response;
    }
// Create user
    @PostMapping("/save")
    public ResponseEntity<Map<String, Object>> createUser(@RequestBody User user) {
        Map<String, Object> response = new HashMap<>();
        try {
            int result = userMapper.saveUser(user);
            if (result == 1) {
                response.put("message", "User created successfully");
                response.put("status", "success");
                return ResponseEntity.ok(response);
            } else {
                response.put("message", "Error creating user");
                response.put("status", "failure");
                return ResponseEntity.status(400).body(response);
            }
        } catch (Exception e) {
            response.put("message", "Internal Server Error: " + e.getMessage());
            response.put("status", "error");
            return ResponseEntity.status(500).body(response);
        }
    }

// Update user

    @PutMapping("/{user_id}")
    public ResponseEntity<String> updateUser(
            @PathVariable("user_id") Long userId,
            @RequestBody User user) {
        try {
            int updated = userMapper.updateUser(userId, user); // Calls the service layer method
            if (updated > 0) {
                return ResponseEntity.ok("User updated successfully.");
            } else {
                return ResponseEntity.status(404).body("User not found.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error updating user: " + e.getMessage());
        }
    }

// Delete user

    @DeleteMapping("/{user_id}")
    public ResponseEntity<String> deleteUser(@PathVariable("user_id") Long userId) {
        try {
            int rowsDeleted = userMapper.deleteUser(userId);
            if (rowsDeleted > 0) {
                return ResponseEntity.ok("User deleted successfully.");
            } else {
                return ResponseEntity.status(404).body("User not found.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error deleting user: " + e.getMessage());
        }
    }


}


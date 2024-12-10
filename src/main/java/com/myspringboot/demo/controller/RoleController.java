package com.myspringboot.demo.controller;

import com.myspringboot.demo.mapper.RoleMapper;
import com.myspringboot.demo.model.Permissions;
import com.myspringboot.demo.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/Roles")
public class RoleController {

    @Autowired
    RoleMapper roleMapper;

    @GetMapping("/list")
    public Map<String, Object> listallRoles() {
        List<HashMap<String, Object>> allpermission = roleMapper.listallrole();
        Map<String, Object> response = new HashMap<>();
        response.put("message", "User retrieved successfully");
        response.put("status", "success");
        response.put("data", allpermission);

        return response;
    }

    @PostMapping("/save")
    public ResponseEntity<Map<String, Object>> createRole(@RequestBody Role role) {
        Map<String, Object> response = new HashMap<>();
        try {
            int result = roleMapper.saveroles(role);
            if (result == 1) {
                response.put("message", "Role created successfully");
                response.put("status", "success");
                return ResponseEntity.ok(response);
            } else {
                response.put("message", "Error creating Role");
                response.put("status", "failure");
                return ResponseEntity.status(400).body(response);
            }
        } catch (Exception e) {
            response.put("message", "Internal Server Error: " + e.getMessage());
            response.put("status", "error");
            return ResponseEntity.status(500).body(response);
        }
    }

    @PutMapping("/{r_id}")
    public ResponseEntity<String> updateRole(@PathVariable("r_id") Long rid, @RequestBody Role role) {
        try {
            int updated = roleMapper.updateroles(rid, role); // Calls the service layer method
            if (updated > 0) {
                return ResponseEntity.ok(" Role updated successfully.");
            } else {
                return ResponseEntity.status(404).body(" Role not found.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error updating Role : " + e.getMessage());
        }
    }

    @DeleteMapping("/{p_id}")
    public ResponseEntity<String> deleteUser(@PathVariable("p_id") Long pid) {
        try {
            int rowsDeleted = roleMapper.deleteroles(pid);
            if (rowsDeleted > 0) {
                return ResponseEntity.ok("Role deleted successfully.");
            } else {
                return ResponseEntity.status(404).body("Role not found.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error deleting Role: " + e.getMessage());
        }
    }
}

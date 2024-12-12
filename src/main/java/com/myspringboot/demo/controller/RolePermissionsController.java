package com.myspringboot.demo.controller;

import com.myspringboot.demo.mapper.PermissionsMapper;
import com.myspringboot.demo.mapper.RolePermissionsMapper;
import com.myspringboot.demo.model.Role;
import com.myspringboot.demo.model.RolePermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Rolespermissions")
public class RolePermissionsController {
    @Autowired
    RolePermissionsMapper rolePermissionsMapper;
    // List all RolePermissions
    @GetMapping("/list")
    public ResponseEntity<Map<String, Object>> getAllRolePermissions() {
        try {
            List<HashMap<String, Object>> allRolePermissions = rolePermissionsMapper.Listallrolepermissions();
            Map<String, Object> response = new HashMap<>();
            response.put("message", "RolePermissions retrieved successfully");
            response.put("status", "success");
            response.put("data", allRolePermissions);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("message", "Error retrieving RolePermissions");
            errorResponse.put("status", "error");
            errorResponse.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    // Save a new RolePermission
    @PostMapping("/save")
    public ResponseEntity<Map<String, String>> saveRolePermission(@RequestBody RolePermissions rolePermissions) {
        Map<String, String> response = new HashMap<>();
        try {
            int result = rolePermissionsMapper.Saverolepermission(rolePermissions);
            if (result > 0) {
                response.put("message", "RolePermission saved successfully.");
                return ResponseEntity.ok(response);
            } else {
                response.put("message", "Failed to save RolePermission.");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
            }
        } catch (Exception e) {
            if (e.getCause() instanceof java.sql.SQLIntegrityConstraintViolationException) {
                response.put("message", "Foreign key constraint violated. Ensure r_id and p_id exist.");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            }
            response.put("message", "An unexpected error occurred: " + e.getMessage());
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    // Update an existing RolePermission
    @PutMapping("/{role_p_id}")
    public ResponseEntity<String> updateRolePermission(
            @PathVariable("role_p_id") Long role_p_id,
            @RequestBody RolePermissions rolePermissions) {
        int result = rolePermissionsMapper.Updaterolpermission(role_p_id, rolePermissions);
        if (result > 0) {
            return ResponseEntity.ok("RolePermission updated successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update RolePermission.");
        }
    }

    // Delete a RolePermission by ID
    @DeleteMapping("{role_p_id}")
    public ResponseEntity<String> deleteRolePermission(@PathVariable("role_p_id") Long role_p_id) {
        int result = rolePermissionsMapper.Deleterolpermission(role_p_id);
        if (result > 0) {
            return ResponseEntity.ok("RolePermission deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete RolePermission.");
        }
    }

}

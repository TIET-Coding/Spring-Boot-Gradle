package com.myspringboot.demo.controller;

import com.myspringboot.demo.mapper.PermissionsMapper;
import com.myspringboot.demo.model.Permissions;
import com.myspringboot.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Permissions")
public class PermissionsController {

    @Autowired
    PermissionsMapper permissionsMapper;

    // List Permisstion
    @GetMapping("/list")
    public Map<String, Object> listallPermissions() {
        List<HashMap<String, Object>> allpermission = permissionsMapper.Listallpermission();
        Map<String, Object> response = new HashMap<>();
        response.put("message", "User retrieved successfully");
        response.put("status", "success");
        response.put("data", allpermission);

        return response;
    }
    // Create Permission
    @PostMapping("/save")
    public ResponseEntity<Map<String, Object>> createPermission(@RequestBody Permissions permissions) {
        Map<String, Object> response = new HashMap<>();
        try {
            int result = permissionsMapper.savePermissions(permissions);
            if (result == 1) {
                response.put("message", "Permission created successfully");
                response.put("status", "success");
                return ResponseEntity.ok(response);
            } else {
                response.put("message", "Error creating Permission");
                response.put("status", "failure");
                return ResponseEntity.status(400).body(response);
            }
        } catch (Exception e) {
            response.put("message", "Internal Server Error: " + e.getMessage());
            response.put("status", "error");
            return ResponseEntity.status(500).body(response);
        }
    }


    @PutMapping("/{p_id}")
    public ResponseEntity<String> updatePermissions(@PathVariable("p_id") Long pid, @RequestBody Permissions permissions) {
        try {
            int updated = permissionsMapper.updatePermissions(pid, permissions); // Calls the service layer method
            if (updated > 0) {
                return ResponseEntity.ok("Permission updated successfully.");
            } else {
                return ResponseEntity.status(404).body("Permission not found.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error updating Permission: " + e.getMessage());
        }
    }

    @DeleteMapping("/{p_id}")
    public ResponseEntity<String> deleteUser(@PathVariable("p_id") Long pid) {
        try {
            int rowsDeleted = permissionsMapper.deletePermissions(pid);
            if (rowsDeleted > 0) {
                return ResponseEntity.ok("Permissions deleted successfully.");
            } else {
                return ResponseEntity.status(404).body("Permission not found.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error deleting Permission: " + e.getMessage());
        }
    }
}

package com.myspringboot.demo.controller;

import com.myspringboot.demo.mapper.ClasseMapper;
import com.myspringboot.demo.model.Classes;
import com.myspringboot.demo.model.Master;
import com.myspringboot.demo.model.Permissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("Classes")
public class ClasseController {
    @Autowired
    ClasseMapper classeMapper;
    @GetMapping("/list")
    public Map<String, Object> listallClasse() {
        List<HashMap<String, Object>> allClasse = classeMapper.listallclasses();
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Clesses retrieved successfully");
        response.put("status", "success");
        response.put("data", allClasse);

        return response;
    }
    // Create Permission
    @PostMapping("/save")
    public ResponseEntity<Map<String, Object>> createClasses(@RequestBody Classes classes) {
        Map<String, Object> response = new HashMap<>();
        try {
            int result = classeMapper.saveClasses(classes);
            if (result == 1) {
                response.put("message", "Classes created successfully");
                response.put("status", "success");
                return ResponseEntity.ok(response);
            } else {
                response.put("message", "Error creating Classes");
                response.put("status", "failure");
                return ResponseEntity.status(400).body(response);
            }
        } catch (Exception e) {
            response.put("message", "Internal Server Error: " + e.getMessage());
            response.put("status", "error");
            return ResponseEntity.status(500).body(response);
        }
    }


    @PutMapping("/{CL_ID}")
    public ResponseEntity<String> updateClasses(@PathVariable Long CL_ID, @RequestBody Classes classes) {
        try {
            int result = classeMapper.updateClasses(CL_ID, classes);

            if (result > 0) {
                return ResponseEntity.ok("Classes updated successfully");
            } else {
                return ResponseEntity.status(404).body("Classes not found with id: " + CL_ID);
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("An error occurred: " + e.getMessage());
        }
    }

    @DeleteMapping("/{CL_ID}")
    public ResponseEntity<String> deleteUser(@PathVariable("CL_ID") Long cid) {
        try {
            int rowsDeleted = classeMapper.deleteClasses(cid);
            if (rowsDeleted > 0) {
                return ResponseEntity.ok("Classes deleted successfully.");
            } else {
                return ResponseEntity.status(404).body("Classes not found.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error deleting Permission: " + e.getMessage());
        }
    }
}

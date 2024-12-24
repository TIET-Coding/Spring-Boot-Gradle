package com.myspringboot.demo.controller;

import com.myspringboot.demo.mapper.TeachersMapper;
import com.myspringboot.demo.model.Schools;
import com.myspringboot.demo.model.Teachers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Teachers")
public class TeachersController {
    @Autowired
    TeachersMapper teachersMapper;

    @GetMapping("/list")
    public Map<String, Object> listallTeacher() {
        List<HashMap<String, Object>> allteacher = teachersMapper.listallTeachers();
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Teachers retrieved successfully");
        response.put("status", "success");
        response.put("data", allteacher);

        return response;
    }

    @PostMapping("/save")
    public ResponseEntity<Map<String, Object>> createSchools(@RequestBody Teachers teachers) {
        Map<String, Object> response = new HashMap<>();
        try {
            int result = teachersMapper.saveTeacher(teachers);
            if (result == 1) {
                response.put("message", "Teachers created successfully");
                response.put("status", "success");
                return ResponseEntity.ok(response);
            } else {
                response.put("message", "Error creating Teachers");
                response.put("status", "failure");
                return ResponseEntity.status(400).body(response);
            }
        } catch (Exception e) {
            response.put("message", "Internal Server Error: " + e.getMessage());
            response.put("status", "error");
            return ResponseEntity.status(500).body(response);
        }
    }
    @PutMapping("/{TH_ID}")
    public ResponseEntity<String> updateTeachers(@PathVariable("TH_ID") Long thid, @RequestBody Teachers teachers) {
        try {
            int updated = teachersMapper.updateTeacher(thid, teachers); // Calls the service layer method
            if (updated > 0) {
                return ResponseEntity.ok("Teachers updated successfully.");
            } else {
                return ResponseEntity.status(404).body("Teachers not found.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error updating Teachers: " + e.getMessage());
        }
    }

    @DeleteMapping("/{TH_ID}")
    public ResponseEntity<String> deleteTeacher(@PathVariable("TH_ID") long TH_ID) {
        try {
            int rowsDeleted = teachersMapper.deleteTeacher(TH_ID);
            if (rowsDeleted > 0) {
                return ResponseEntity.ok("Teachers deleted successfully.");
            } else {
                return ResponseEntity.status(404).body("Teachers not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error deleting Teachers: " + e.getMessage());
        }
    }
}

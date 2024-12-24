package com.myspringboot.demo.controller;

import com.myspringboot.demo.mapper.SchoolsMapper;
import com.myspringboot.demo.model.Permissions;
import com.myspringboot.demo.model.Schools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Schools")
public class SchoolsController {
    @Autowired
    SchoolsMapper schoolsMapper;
    // List Schools
    @GetMapping("/list")
    public Map<String, Object> listallSchools() {
        List<HashMap<String, Object>> allschools = schoolsMapper.listallSchools();
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Schools retrieved successfully");
        response.put("status", "success");
        response.put("data", allschools);

        return response;
    }

    //  Create Schools
    @PostMapping("/save")
    public ResponseEntity<Map<String, Object>> createSchools(@RequestBody Schools schools) {
        Map<String, Object> response = new HashMap<>();
        try {
            int result = schoolsMapper.saveSchools(schools);
            if (result == 1) {
                response.put("message", "Schools created successfully");
                response.put("status", "success");
                return ResponseEntity.ok(response);
            } else {
                response.put("message", "Error creating Schools");
                response.put("status", "failure");
                return ResponseEntity.status(400).body(response);
            }
        } catch (Exception e) {
            response.put("message", "Internal Server Error: " + e.getMessage());
            response.put("status", "error");
            return ResponseEntity.status(500).body(response);
        }
    }
    @PutMapping("/{SCH_ID}")
    public ResponseEntity<String> updateSchools(@PathVariable("SCH_ID") Long schid, @RequestBody Schools schools) {
        try {
            int updated = schoolsMapper.updateSchools(schid, schools); // Calls the service layer method
            if (updated > 0) {
                return ResponseEntity.ok("Schools updated successfully.");
            } else {
                return ResponseEntity.status(404).body("Schools not found.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error updating Schools: " + e.getMessage());
        }
    }

    @DeleteMapping("/{SCH_ID}")
    public ResponseEntity<String> deleteSchools(@PathVariable("SCH_ID") long SCH_ID) {
        try {
            int rowsDeleted = schoolsMapper.deleteSchools(SCH_ID);
            if (rowsDeleted > 0) {
                return ResponseEntity.ok("School deleted successfully.");
            } else {
                return ResponseEntity.status(404).body("School not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error deleting school: " + e.getMessage());
        }
    }

}

package com.myspringboot.demo.controller;

import com.myspringboot.demo.mapper.SubjectsMapper;
import com.myspringboot.demo.model.Subjects;
import com.myspringboot.demo.model.Teachers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("Subjects")
public class SubjectsController {
    @Autowired
    SubjectsMapper subjectsMapper;

    @GetMapping("/list")
    public Map<String, Object> listallSubjects() {
        List<HashMap<String, Object>> allsubjects = subjectsMapper.listallSubjects();
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Subjects retrieved successfully");
        response.put("status", "success");
        response.put("data", allsubjects);

        return response;
    }
    @PostMapping("/save")
    public ResponseEntity<Map<String, Object>> createSubjects(@RequestBody Subjects subjects) {
        Map<String, Object> response = new HashMap<>();
        try {
            int result = subjectsMapper.saveSubjects(subjects);
            if (result == 1) {
                response.put("message", "Subjects created successfully");
                response.put("status", "success");
                return ResponseEntity.ok(response);
            } else {
                response.put("message", "Error creating Subjects");
                response.put("status", "failure");
                return ResponseEntity.status(400).body(response);
            }
        } catch (Exception e) {
            response.put("message", "Internal Server Error: " + e.getMessage());
            response.put("status", "error");
            return ResponseEntity.status(500).body(response);
        }
    }

    @PutMapping("/{SJ_ID}")
    public ResponseEntity<String> updateTeachers(@PathVariable("SJ_ID") Long sjid, @RequestBody Subjects subjects) {
        try {
            int updated = subjectsMapper.updateSubjects(sjid, subjects); // Calls the service layer method
            if (updated > 0) {
                return ResponseEntity.ok("Subjects updated successfully.");
            } else {
                return ResponseEntity.status(404).body("Subjects not found.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error updating Subjects: " + e.getMessage());
        }
    }
    @DeleteMapping("/{SJ_ID}")
    public ResponseEntity<String> deleteTeacher(@PathVariable("SJ_ID") long SJ_ID) {
        try {
            int rowsDeleted = subjectsMapper.deleteSubjects(SJ_ID);
            if (rowsDeleted > 0) {
                return ResponseEntity.ok("Subjects deleted successfully.");
            } else {
                return ResponseEntity.status(404).body("Subjects not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error deleting Subjects: " + e.getMessage());
        }
    }


}

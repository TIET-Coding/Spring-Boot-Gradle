package com.myspringboot.demo.controller;

import com.myspringboot.demo.mapper.ParentsMapper;
import com.myspringboot.demo.model.Parents;
import com.myspringboot.demo.model.Teachers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Parents")
public class ParentsController {
    @Autowired
    ParentsMapper parentsMapper;

    @GetMapping("/list")
    public Map<String, Object> listallParents() {
        List<HashMap<String, Object>> allparents = parentsMapper.listallparents();
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Teachers retrieved successfully");
        response.put("status", "success");
        response.put("data", allparents);

        return response;
    }

    @PostMapping("/save")
    public ResponseEntity<Map<String, Object>> createparents(@RequestBody Parents parents) {
        Map<String, Object> response = new HashMap<>();
        try {
            int result = parentsMapper.saveParents(parents);
            if (result == 1) {
                response.put("message", "Parents created successfully");
                response.put("status", "success");
                return ResponseEntity.ok(response);
            } else {
                response.put("message", "Error creating Parents");
                response.put("status", "failure");
                return ResponseEntity.status(400).body(response);
            }
        } catch (Exception e) {
            response.put("message", "Internal Server Error: " + e.getMessage());
            response.put("status", "error");
            return ResponseEntity.status(500).body(response);
        }
    }
    @PutMapping("/{P_ID}")
    public ResponseEntity<String> updateparents(@PathVariable("P_ID") Long pid, @RequestBody Parents parents) {
        try {
            int updated = parentsMapper.updateParents(pid, parents); // Calls the service layer method
            if (updated > 0) {
                return ResponseEntity.ok("Parents updated successfully.");
            } else {
                return ResponseEntity.status(404).body("Parents not found.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error updating Parents: " + e.getMessage());
        }
    }

    @DeleteMapping("/{P_ID}")
    public ResponseEntity<String> deleteparents(@PathVariable("P_ID") long P_ID) {
        try {
            int rowsDeleted = parentsMapper.deleteParents(P_ID);
            if (rowsDeleted > 0) {
                return ResponseEntity.ok("Parents deleted successfully.");
            } else {
                return ResponseEntity.status(404).body("Parents not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error deleting Parents: " + e.getMessage());
        }
    }
}

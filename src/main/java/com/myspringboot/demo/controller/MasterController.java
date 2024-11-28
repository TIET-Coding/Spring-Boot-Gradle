package com.myspringboot.demo.controller;

import com.myspringboot.demo.mapper.MasterMapper;
import com.myspringboot.demo.mapper.UserMapper;
import com.myspringboot.demo.model.Master;
import com.myspringboot.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("Masters")
public class MasterController {
    @Autowired
    MasterMapper masterMapper;

    @GetMapping("/list")
    public Map<String, Object> listmaster(){
        List<HashMap<String, Object>> allmaster = masterMapper.Listallmaster();
        // Ensure allMaster is not null to avoid NullPointerException
        if (allmaster == null) {
            throw new RuntimeException("Error: List is null");
        }
        Map<String, Object> response = new HashMap<>();
        if (allmaster.isEmpty()) {
            response.put("message", "No users found");
            response.put("status", "success");
            response.put("data", allmaster);  // Return an empty list instead of null
            return response;  // Default 200 OK response
        }
        response.put("message","User retrieved successfully");
        response.put("status", "success");
        response.put("data", allmaster);

        return response;
    }

    // Create Master

    @PostMapping("/save")
    public ResponseEntity<String> saveMaster(@RequestBody Master master) {
        try {
            // Call the service to save the Master object
            int result = masterMapper.saveMaster(master);

            if (result > 0) {
                return ResponseEntity.ok("Master saved successfully");
            } else {
                return ResponseEntity.status(500).body("Failed to save Master");
            }
        } catch (Exception e) {
            // Log the error and return a generic error message
            return ResponseEntity.status(500).body("An error occurred: " + e.getMessage());
        }
    }

    // Update Master
    @PutMapping("/{id}")
    public ResponseEntity<String> updateMaster(@PathVariable Long id, @RequestBody Master master) {
        try {
            int result = masterMapper.updateMaster(id, master);

            if (result > 0) {
                return ResponseEntity.ok("Master updated successfully");
            } else {
                return ResponseEntity.status(404).body("Master not found with id: " + id);
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("An error occurred: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMaster(@PathVariable Long id) {
        try {
            int result = masterMapper.deleteMaster(id);

            if (result > 0) {
                return ResponseEntity.ok("Master deleted successfully");
            } else {
                return ResponseEntity.status(404).body("Master not found with id: " + id);
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("An error occurred: " + e.getMessage());
        }
    }
}

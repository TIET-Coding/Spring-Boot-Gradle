package com.myspringboot.demo.controller;

import com.myspringboot.demo.mapper.GradesMapper;
import com.myspringboot.demo.model.Grades;
import com.myspringboot.demo.model.Parents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Grades")
public class GradesController {

    @Autowired
    GradesMapper gradesMapper;

    // Fetch all grades
    @GetMapping("/list")
    public Map<String, Object> listallGrades() {
        List<HashMap<String, Object>> allgrades = gradesMapper.listAllGrades();
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Grades retrieved successfully");
        response.put("status", "success");
        response.put("data", allgrades);

        return response;
    }

    // Save a new grade
    @PostMapping("/save")
    public ResponseEntity<Map<String, Object>> creategrades(@RequestBody Grades grades) {
        Map<String, Object> response = new HashMap<>();
        try {
            int result = gradesMapper.saveGrades(grades);
            if (result == 1) {
                response.put("message", "Grades created successfully");
                response.put("status", "success");
                return ResponseEntity.ok(response);
            } else {
                response.put("message", "Error creating Grades");
                response.put("status", "failure");
                return ResponseEntity.status(400).body(response);
            }
        } catch (Exception e) {
            response.put("message", "Internal Server Error: " + e.getMessage());
            response.put("status", "error");
            return ResponseEntity.status(500).body(response);
        }
    }
    // Update in the grade
    @PutMapping("/{G_ID}")
    public ResponseEntity<String> updateGrades(
            @PathVariable("G_ID") long G_ID,
            @RequestBody Grades grades) {
        try {
            // Log the incoming G_ID and Grades object
            System.out.println("G_ID: " + G_ID);
            System.out.println("Grades object: " + grades);

            if (grades == null) {
                return ResponseEntity.status(400).body("Invalid Grades data: null input.");
            }

            // Call the mapper
            int result = gradesMapper.updateGrades(G_ID, grades);

            // Log the result of the update
            System.out.println("Update result: " + result);

            if (result > 0) {
                return ResponseEntity.ok("Grades updated successfully.");
            } else {
                return ResponseEntity.status(404).body("Grade with ID " + G_ID + " not found.");
            }
        } catch (Exception e) {
            // Log the exception and print the stack trace for detailed debugging
            e.printStackTrace();
            return ResponseEntity.status(500).body("An error occurred: " +
                    (e.getMessage() != null ? e.getMessage() : "No detailed message available"));
        }
    }
    // Delete a grade
    @DeleteMapping("/{G_ID}")
    public ResponseEntity<String> deleteGrades(@PathVariable("G_ID") long G_ID) {
        try {
            // Call the mapper to delete the grades
            int result = gradesMapper.deleteGrades(G_ID);

            // Check the result of the delete operation
            if (result > 0) {
                return ResponseEntity.ok("Grade with ID " + G_ID + " deleted successfully.");
            } else {
                return ResponseEntity.status(404).body("Grade with ID " + G_ID + " not found.");
            }
        } catch (Exception e) {
            // Log the error and return a 500 response
            e.printStackTrace();
            return ResponseEntity.status(500).body("An error occurred while deleting the grade: " +
                    (e.getMessage() != null ? e.getMessage() : "No detailed message available"));
        }
    }

}

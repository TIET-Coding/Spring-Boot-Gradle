package com.myspringboot.demo.controller;

import com.myspringboot.demo.mapper.FeesMapper;
import com.myspringboot.demo.model.Fees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/Fees")
public class FeesController {
    @Autowired
    FeesMapper feesMapper;

    @GetMapping("/list")
    public ResponseEntity<Map<String, Object>> listAllFees() {
        List<HashMap<String, Object>> allFees = feesMapper.listallFees();
        Map<String, Object> response = new HashMap<>();

        if (allFees.isEmpty()) {
            response.put("message", "No Fees found.");
            response.put("status", "success");
            response.put("data", Collections.emptyList());
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
        }

        response.put("message", "Fees retrieved successfully.");
        response.put("status", "success");
        response.put("data", allFees);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/save")
    public ResponseEntity<Map<String, Object>> saveFees(@RequestBody Fees fees) {
        Map<String, Object> response = new HashMap<>();

        try {
            int result = feesMapper.saveFees(fees);
            if (result > 0) {
                response.put("message", "Fees saved successfully.");
                response.put("status", "success");
                return ResponseEntity.status(HttpStatus.CREATED).body(response);
            } else {
                response.put("message", "Failed to save fees.");
                response.put("status", "error");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
            }
        } catch (Exception e) {
            response.put("message", "Error: " + e.getMessage());
            response.put("status", "error");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }


    @PutMapping("/{F_ID}")
    public ResponseEntity<Map<String, Object>> updateFees(@PathVariable("F_ID") long F_ID, @RequestBody Fees fees) {
        Map<String, Object> response = new HashMap<>();

        try {
            int result = feesMapper.updateFees(F_ID, fees);
            if (result > 0) {
                response.put("message", "Fees updated successfully.");
                response.put("status", "success");
                return ResponseEntity.ok(response);
            } else {
                response.put("message", "Fees with F_ID " + F_ID + " not found.");
                response.put("status", "error");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
        } catch (Exception e) {
            response.put("message", "Error: " + e.getMessage());
            response.put("status", "error");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @DeleteMapping("/{F_ID}")
    public ResponseEntity<Map<String, Object>> deleteFees(@PathVariable("F_ID") long F_ID) {
        Map<String, Object> response = new HashMap<>();
        int result = feesMapper.deleteFees(F_ID);

        if (result > 0) {
            response.put("message", "Fees deleted successfully.");
            response.put("status", "success");
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "Failed to delete fees.");
            response.put("status", "error");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}

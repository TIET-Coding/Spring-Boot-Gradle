package com.myspringboot.demo.controller;

import com.myspringboot.demo.mapper.AttendanceMapper;
import com.myspringboot.demo.model.Attendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Attendance")
public class AttendanceController {
    @Autowired
    AttendanceMapper attendanceMapper;

    @GetMapping("/list")
    public ResponseEntity<Map<String, Object>> listallAttendance() {
        List<HashMap<String, Object>> allAttendance = attendanceMapper.listallAttendance();
        Map<String, Object> response = new HashMap<>();

        if (allAttendance.isEmpty()) {
            response.put("message", "No Attendance found.");
            response.put("status", "success");
            response.put("data", Collections.emptyList());
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
        }

        response.put("message", "Attendance retrieved successfully.");
        response.put("status", "success");
        response.put("data", allAttendance);

        return ResponseEntity.ok(response);
    }

    // Save a new attendance record
    @PostMapping("/save")
    public ResponseEntity<Map<String, Object>> saveAttendance(@RequestBody Attendance attendance) {
        Map<String, Object> response = new HashMap<>();
        try {
            int result = attendanceMapper.saveAttendance(attendance);
            if (result > 0) {
                response.put("message", "Attendance saved successfully.");
                response.put("status", "success");
            } else {
                response.put("message", "Failed to save attendance.");
                response.put("status", "error");
            }
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("message", "An error occurred while saving attendance.");
            response.put("status", "error");
            response.put("error", e.getMessage());
            e.printStackTrace(); // Log the full stack trace
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    // Update an existing attendance record
    @PutMapping("/{A_ID}")
    public ResponseEntity<Map<String, Object>> updateAttendance(@PathVariable("A_ID") long A_ID, @RequestBody Attendance attendance) {
        Map<String, Object> response = new HashMap<>();
        try {
            // Validate input fields
            if (attendance.getDate() == null || attendance.getDate().isEmpty()) {
                response.put("message", "Date cannot be null or empty.");
                response.put("status", "error");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            }

            int result = attendanceMapper.updateAttendance(A_ID, attendance);
            if (result > 0) {
                response.put("message", "Attendance updated successfully.");
                response.put("status", "success");
            } else {
                response.put("message", "Attendance with ID " + A_ID + " not found.");
                response.put("status", "error");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("message", "An error occurred while updating attendance.");
            response.put("status", "error");
            response.put("error", e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    // Delete an attendance record
    @DeleteMapping("/{A_ID}")
    public ResponseEntity<Map<String, Object>> deleteAttendance(@PathVariable("A_ID") long A_ID) {
        Map<String, Object> response = new HashMap<>();
        int result = attendanceMapper.deleteAttendance(A_ID);

        if (result > 0) {
            response.put("message", "Attendance deleted successfully.");
            response.put("status", "success");
        } else {
            response.put("message", "Failed to delete attendance. Record may not exist.");
            response.put("status", "error");
        }

        return ResponseEntity.ok(response);
    }


}

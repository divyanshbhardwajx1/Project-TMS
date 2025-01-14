package com.example.smarttraffic.controller;

import com.smarttrafficmanagementsystem.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/traffic")
public class TrafficController {

    @GetMapping("/{id}")
    public ResponseEntity<String> getTrafficData(@PathVariable Long id) {
        // Simulate fetching traffic data
        if (id != 1) { // Example logic
            throw new ResourceNotFoundException("Traffic data not found for ID " + id);
        }

        return ResponseEntity.ok("Traffic data for ID " + id);
    }

    @PostMapping
    public ResponseEntity<String> createTrafficData(@RequestBody @Valid TrafficRequestDTO requestDTO) {
        return ResponseEntity.ok("Traffic data created successfully");
    }
}

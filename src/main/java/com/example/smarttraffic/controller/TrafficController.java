package com.example.smarttraffic.controller;

import com.example.smarttraffic.model.TrafficData;
import com.example.smarttraffic.service.TrafficService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/traffic")
public class TrafficController {
    @Autowired
    private TrafficService trafficService;

    @GetMapping
    public List<TrafficData> getTrafficData() {
        return trafficService.getAllTrafficData();
    }

    @PostMapping
    public TrafficData addTrafficData(@RequestBody TrafficData trafficData) {
        return trafficService.saveTrafficData(trafficData);
    }
}

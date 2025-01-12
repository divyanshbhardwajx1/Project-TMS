package com.example.smarttraffic.service;

import com.example.smarttraffic.model.TrafficData;
import com.example.smarttraffic.repository.TrafficDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrafficService {
    @Autowired
    private TrafficDataRepository trafficDataRepository;

    public List<TrafficData> getAllTrafficData() {
        return trafficDataRepository.findAll();
    }

    public TrafficData saveTrafficData(TrafficData trafficData) {
        return trafficDataRepository.save(trafficData);
    }
}

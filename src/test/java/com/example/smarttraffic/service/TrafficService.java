package com.example.smarttraffic.service;

import com.example.smarttraffic.model.TrafficData;
import com.example.smarttraffic.repository.TrafficDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrafficService {

    @Autowired
    private TrafficDataRepository trafficDataRepository;

    public TrafficData saveTrafficData(TrafficData trafficData) {
        return trafficDataRepository.save(trafficData);
    }

    public TrafficData getTrafficDataById(Long id) {
        return trafficDataRepository.findById(id).orElse(null);
    }
}

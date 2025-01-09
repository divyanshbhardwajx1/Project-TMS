package com.example.service;

import com.example.dao.TrafficDao;
import com.example.model.TrafficDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrafficService {

    @Autowired
    private TrafficDao trafficDao;

    public TrafficDetails getTrafficDetails(String locationId) {
        return trafficDao.fetchTrafficDetails(locationId);
    }

    public boolean saveTrafficDetails(TrafficDetails details) {
        return trafficDao.saveTrafficDetails(details) > 0;
    }
}

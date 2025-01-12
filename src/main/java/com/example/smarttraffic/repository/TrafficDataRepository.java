package com.example.smarttraffic.repository;

import com.example.smarttraffic.model.TrafficData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrafficDataRepository extends JpaRepository<TrafficData, Long> {
    // Custom query methods if needed
}

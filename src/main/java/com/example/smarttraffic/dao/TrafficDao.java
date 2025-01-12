package com.example.smarttraffic.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.smarttraffic.model.TrafficDetails;

@Repository
public class TrafficDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public TrafficDetails fetchTrafficDetails(String locationId) {
        String query = "SELECT * FROM traffic WHERE location_id = ?";
        return jdbcTemplate.queryForObject(query, new Object[]{locationId},
            (rs, rowNum) -> new TrafficDetails(rs.getString("location_id"), rs.getString("traffic_level")));
    }

    public int saveTrafficDetails(TrafficDetails details) {
        String query = "INSERT INTO traffic (location_id, traffic_level) VALUES (?, ?)";
        return jdbcTemplate.update(query, details.getLocationId(), details.getTrafficLevel());
    }
}

package com.example.smarttraffic.dao;

import com.example.smarttraffic.dao.TrafficDao;
import com.example.smarttraffic.model.TrafficDetails;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
public class TrafficDaoTest {

    @Autowired
    private TrafficDao trafficDao;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    public void setupDatabase() {
        jdbcTemplate.execute("CREATE TABLE traffic (location_id VARCHAR(255), traffic_level VARCHAR(255))");
        jdbcTemplate.execute("INSERT INTO traffic (location_id, traffic_level) VALUES ('loc1', 'High Traffic')");
    }

    @Test
    public void testFetchTrafficDetails() {
        TrafficDetails details = trafficDao.fetchTrafficDetails("loc1");
        assertNotNull(details);
        assertEquals("High Traffic", details.getTrafficLevel());
    }

    @Test
    public void testSaveTrafficDetails() {
        TrafficDetails newDetails = new TrafficDetails("loc2", "Moderate Traffic");
        int result = trafficDao.saveTrafficDetails(newDetails);
        assertEquals(1, result);
    }
}

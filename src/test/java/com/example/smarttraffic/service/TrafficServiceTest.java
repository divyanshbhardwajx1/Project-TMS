package com.example.smarttraffic.service;

import com.example.smarttraffic.model.TrafficData;
import com.example.smarttraffic.repository.TrafficDataRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
import static org.mockito.Mockito.when;

    @Mock
    private TrafficDataRepository trafficDataRepository;

    @InjectMocks
    private TrafficService trafficService;

    private TrafficData trafficData;

    @BeforeEach
    public void setUp() {
        trafficData = new TrafficData();
        trafficData.setLocation("Downtown");
        trafficData.setVehicleCount(100);
        trafficData.setTimestamp("2025-01-12T08:00:00");
    }

    @Test
    public void testSaveTrafficData() {
        // Mocking the repository's save method
        when(trafficDataRepository.save(Mockito.any(TrafficData.class))).thenReturn(trafficData);

        // Calling the service method
        TrafficData savedData = trafficService.saveTrafficData(trafficData);

        // Assert that the data returned by service is correct
        assertEquals("Downtown", savedData.getLocation());
        assertEquals(100, savedData.getVehicleCount());
    }

    @Test
    public void testGetTrafficDataById() {
        // Mocking the repository's findById method
        when(trafficDataRepository.findById(1L)).thenReturn(java.util.Optional.of(trafficData));

        // Calling the service method
        TrafficData data = trafficService.getTrafficDataById(1L);

        // Assert that the data returned by service is correct
        assertEquals("Downtown", data.getLocation());
    }
}

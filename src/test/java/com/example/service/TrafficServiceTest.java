package com.example.service;

import com.example.dao.TrafficDao;
import com.example.model.TrafficDetails;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class TrafficServiceTest {

    @Mock
    private TrafficDao trafficDao;

    @InjectMocks
    private TrafficService trafficService;

    @Test
    public void testGetTrafficDetails() {
        TrafficDetails mockDetails = new TrafficDetails("loc1", "Heavy Traffic");
        when(trafficDao.fetchTrafficDetails("loc1")).thenReturn(mockDetails);

        TrafficDetails details = trafficService.getTrafficDetails("loc1");

        assertNotNull(details);
        assertEquals("Heavy Traffic", details.getTrafficLevel());
        verify(trafficDao, times(1)).fetchTrafficDetails("loc1");
    }

    @Test
    public void testSaveTrafficDetails() {
        TrafficDetails newDetails = new TrafficDetails("loc2", "Light Traffic");
        when(trafficDao.saveTrafficDetails(newDetails)).thenReturn(1);

        boolean isSaved = trafficService.saveTrafficDetails(newDetails);

        assertTrue(isSaved);
        verify(trafficDao, times(1)).saveTrafficDetails(newDetails);
    }
}

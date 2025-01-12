package com.example.smarttraffic.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TrafficSignalTest {

    @Test
    public void testTrafficSignalFields() {
        TrafficSignalTest signal = new TrafficSignalTest(1L, "Highway 1", "GREEN");

        assertEquals(1L, signal.getId());
        assertEquals("Highway 1", signal.getName());
        assertEquals("GREEN", signal.getStatus());
    }

    @Test
    public void testTrafficSignalEquality() {
        TrafficSignalTest signal1 = new TrafficSignalTest(1L, "Crossroad", "RED");
        TrafficSignalTest signal2 = new TrafficSignalTest(1L, "Crossroad", "RED");

        assertEquals(signal1, signal2);
    }
}

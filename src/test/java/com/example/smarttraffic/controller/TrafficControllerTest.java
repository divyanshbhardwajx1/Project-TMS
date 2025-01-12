package com.example.smarttraffic.controller;

import com.example.service.TrafficService;
import com.example.smarttraffic.model.TrafficSignal;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TrafficController.class)
class TrafficControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TrafficService trafficService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGetAllSignals() throws Exception {
        TrafficSignal signal1 = new TrafficSignal(1, "Signal 1", "Green");
        TrafficSignal signal2 = new TrafficSignal(2, "Signal 2", "Red");

        Mockito.when(trafficService.getAllSignals()).thenReturn(Arrays.asList(signal1, signal2));

        mockMvc.perform(get("/traffic/signals"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].name").value("Signal 1"))
                .andExpect(jsonPath("$[1].name").value("Signal 2"));
    }

    @Test
    void testGetSignalById() throws Exception {
        TrafficSignal signal = new TrafficSignal(1, "Signal 1", "Green");

        Mockito.when(trafficService.getSignalById(1)).thenReturn(signal);

        mockMvc.perform(get("/traffic/signal/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Signal 1"));
    }

    @Test
    void testAddSignal() throws Exception {
        TrafficSignal signal = new TrafficSignal(1, "Signal 1", "Green");

        Mockito.when(trafficService.addSignal(Mockito.any(TrafficSignal.class))).thenReturn(signal);

        mockMvc.perform(post("/traffic/signal")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(signal)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Signal 1"));
    }

    @Test
    void testUpdateSignal() throws Exception {
        TrafficSignal updatedSignal = new TrafficSignal(1, "Updated Signal", "Yellow");

        Mockito.when(trafficService.updateSignal(Mockito.eq(1), Mockito.any(TrafficSignal.class)))
                .thenReturn(updatedSignal);

        mockMvc.perform(put("/traffic/signal/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedSignal)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Updated Signal"));
    }

    @Test
    void testDeleteSignal() throws Exception {
        Mockito.doNothing().when(trafficService).deleteSignal(1);

        mockMvc.perform(delete("/traffic/signal/1"))
                .andExpect(status().isNoContent());
    }
}

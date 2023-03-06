package com.assessment.drones.controller;

import com.assessment.drones.dto.DroneDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DroneControllerTest {

    RestTemplate restTemplate = new RestTemplate();

    @LocalServerPort
    private int port;

    @Test
    void registerDrone() {
        DroneDto drone = restTemplate.postForEntity(
                "http://localhost:" + port + "/drones",
                DroneDto.builder().serialNumber("TEST").build(),
                DroneDto.class
        ).getBody();
        assertTrue(drone.getSerialNumber().equals("TEST"));
    }

    @Test
    void getDrones() {
        List<DroneDto> drones = restTemplate.exchange(
                "http://localhost:" + port + "/drones",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<DroneDto>>() {}
        ).getBody();
        assertTrue(drones.size() > 0);
    }

    @Test
    void getBatteryLevel() {
        Integer battery = restTemplate.exchange(
                "http://localhost:" + port + "/drones/1/battery",
                HttpMethod.GET,
                null,
                Integer.class
        ).getBody();
        assertTrue(battery > 0);
    }
}
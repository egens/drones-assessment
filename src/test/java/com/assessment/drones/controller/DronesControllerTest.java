package com.assessment.drones.controller;

import com.assessment.drones.dto.DroneDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DronesControllerTest {

    @Autowired
    DroneController dronesController;
    RestTemplate restTemplate = new RestTemplate();

    @LocalServerPort
    private int port;

    @Test
    void test() {
        ResponseEntity<DroneDto> droneResponseEntity = restTemplate.postForEntity(
                "http://localhost:" + port + "/drones",
                DroneDto.builder().serialNumber("TEST").build(),
                DroneDto.class
        );
        assertTrue(droneResponseEntity.getBody().getSerialNumber().equals("TEST"));
    }
}
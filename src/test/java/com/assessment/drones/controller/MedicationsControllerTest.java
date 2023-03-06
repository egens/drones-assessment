package com.assessment.drones.controller;

import com.assessment.drones.dto.MedicationDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MedicationsControllerTest {

    RestTemplate restTemplate = new RestTemplate();

    @LocalServerPort
    private int port;

    @Test
    void loadMedications_getDroneMedications() {
        restTemplate.postForLocation(
                "http://localhost:" + port + "/drones/1/medications",
                List.of(2)
        );

        List<MedicationDto> medications = restTemplate.exchange(
                "http://localhost:" + port + "/drones/1/medications",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<MedicationDto>>() {}
        ).getBody();
        assertTrue(medications.size() > 0);
    }
}
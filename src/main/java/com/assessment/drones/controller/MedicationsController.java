package com.assessment.drones.controller;

import com.assessment.drones.dto.MedicationDto;
import com.assessment.drones.service.MedicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/drones/{droneId}/medications")
@RequiredArgsConstructor
public class MedicationsController {

    private final MedicationService medicationService;

    @PostMapping
    void loadMedications(
            @PathVariable("droneId") String droneId,
            @RequestBody List<String> medicationCodes) {
        medicationService.loadMedications(droneId, medicationCodes);
    }

    @GetMapping
    List<MedicationDto> getDroneMedications(@PathVariable("droneId") String droneId) {
        return medicationService.getDroneMedications(droneId);
    }
}

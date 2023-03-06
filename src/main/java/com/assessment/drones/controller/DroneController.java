package com.assessment.drones.controller;

import com.assessment.drones.dto.DroneDto;
import com.assessment.drones.dto.MedicationDto;
import com.assessment.drones.mapper.DroneMapper;
import com.assessment.drones.mapper.MedicationMapper;
import com.assessment.drones.service.DroneService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * The service should allow:
 * - registering a drone;
 * - loading a drone with medication items;
 * - checking loaded medication items for a given drone;
 * - checking available drones for loading;
 * - check drone battery level for a given drone;
 *    POST PUT DELETE GET PATCH
 */
@RestController
@RequestMapping(path = "/drones")
@RequiredArgsConstructor
public class DroneController {


    private final DroneService droneService;
    private final DroneMapper droneMapper;
    private final MedicationMapper medicationMapper;

    @PostMapping
    DroneDto registerDrone(@Valid @RequestBody DroneDto drone) {
        return droneService.registerDrone(droneDto);
    }

    @PostMapping(path = "/{droneId}/load_medications")
    void loadMedications(
            @PathVariable("droneId") String droneId,
            @RequestBody List<String> medicationCodes) {
        droneService.loadMedications(droneId, medicationCodes);
    }

    @GetMapping(path = "/{droneId}/medications")
    List<MedicationDto> getDroneMedications(@PathVariable("droneId") String droneId) {
        return droneService.getDroneMedications(droneId);
    }

    @GetMapping
    List<DroneDto> getDrones(@RequestParam(required = false, defaultValue = "false") boolean loadingAvailable) {
        return droneService.getDrones(loadingAvailable);
    }

    @GetMapping(path = "/{droneId}/battery")
    Integer getBatteryLevel(@PathVariable("droneId") String droneId) {
        return droneService.getBatteryLevel(droneId);
    }

}

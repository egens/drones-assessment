package com.assessment.drones.controller;

import com.assessment.drones.dto.DroneDto;
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

    @PostMapping
    DroneDto registerDrone(@Valid @RequestBody DroneDto droneDto) {
        return droneService.registerDrone(droneDto);
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

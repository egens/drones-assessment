package com.assessment.drones.dto;

import com.assessment.drones.entity.DroneModel;
import com.assessment.drones.entity.DroneState;
import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * A **Drone** has:
 * - serial number (100 characters max);
 * - model (Lightweight, Middleweight, Cruiserweight, Heavyweight);
 * - weight limit (500gr max);
 * - battery capacity (percentage);
 * - state (IDLE, LOADING, LOADED, DELIVERING, DELIVERED, RETURNING).
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class DroneDto {

    @Size(max = 100)
    private String serialNumber;
    private DroneModel model;
    @Min(0)
    @Max(500)
    private Integer weightLimit;
    @Min(0)
    @Max(100)
    private Integer batteryCapacity;
    private DroneState state;
    private List<MedicationDto> medications;
}

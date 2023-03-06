package com.assessment.drones.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DroneHistory {

    @Id
    private UUID uuid;
    private LocalDateTime timestamp;
    private Integer batteryCapacity;
    @OneToOne
    private Drone drone;
}

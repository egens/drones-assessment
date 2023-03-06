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
    UUID uuid;
    LocalDateTime timestamp;
    Integer batteryCapacity;
    @OneToOne
    Drone drone;
}

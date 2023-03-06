package com.assessment.drones.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Drone {

    @Id
    private String serialNumber;
    @Enumerated(EnumType.STRING)
    private DroneModel model;
    private Integer weightLimit;
    private Integer batteryCapacity;
    @Enumerated(EnumType.STRING)
    private DroneState state;
    @OneToMany
    private List<Medication> medications;
}

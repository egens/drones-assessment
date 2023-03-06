package com.assessment.drones.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Entity
@Getter
public class Drone {

    @Id
    String serialNumber;
    DroneModel model;
    Integer weightLimit;
    Integer batteryCapacity;
    DroneState state;
    @OneToMany
    List<Medication> medications;
}

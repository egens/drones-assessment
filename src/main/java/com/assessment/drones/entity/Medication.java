package com.assessment.drones.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Medication {

    String name;
    Integer weight;
    @Id
    String code;
    String imageUrl;
}

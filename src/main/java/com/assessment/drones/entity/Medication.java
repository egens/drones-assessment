package com.assessment.drones.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
public class Medication {

    String name;
    Integer weight;
    @Id
    String code;
    String imageUrl;
}

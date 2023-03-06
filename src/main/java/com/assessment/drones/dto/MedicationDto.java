package com.assessment.drones.dto;

import lombok.Getter;

import javax.validation.constraints.Pattern;

/**
 * Each **Medication** has:
 * - name (allowed only letters, numbers, ‘-‘, ‘_’);
 * - weight;
 * - code (allowed only upper case letters, underscore and numbers);
 * - image (picture of the medication case).
 */
@Getter
public class MedicationDto {

    @Pattern(regexp = "[A-z0-9-_]")
    String name;
    Integer weight;
    @Pattern(regexp = "[A-Z0-9_]")
    String code;
    String imageUrl;
}

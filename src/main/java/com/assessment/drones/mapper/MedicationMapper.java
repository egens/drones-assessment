package com.assessment.drones.mapper;

import com.assessment.drones.dto.MedicationDto;
import com.assessment.drones.entity.Medication;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MedicationMapper {

    Medication mapFromDto(MedicationDto dto);
}

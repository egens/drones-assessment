package com.assessment.drones.mapper;

import com.assessment.drones.dto.DroneDto;
import com.assessment.drones.dto.MedicationDto;
import com.assessment.drones.entity.Drone;
import com.assessment.drones.entity.Medication;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MedicationMapper {

    Medication mapFromDto(MedicationDto dto);
    List<MedicationDto> mapListToDto(List<Medication> dto);
}

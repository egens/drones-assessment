package com.assessment.drones.mapper;

import com.assessment.drones.dto.MedicationDto;
import com.assessment.drones.entity.Medication;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MedicationMapper {

    Medication mapFromDto(MedicationDto data);
    MedicationDto mapFromDto(Medication data);
    List<MedicationDto> mapListToDto(List<Medication> data);
    List<Medication> mapListFromDto(List<MedicationDto> data);
}

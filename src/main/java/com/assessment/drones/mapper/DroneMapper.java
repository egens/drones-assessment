package com.assessment.drones.mapper;

import com.assessment.drones.dto.DroneDto;
import com.assessment.drones.entity.Drone;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = MedicationMapper.class)
public interface DroneMapper {

    Drone mapFromDto(DroneDto data);
    DroneDto mapToDto(Drone data);
    List<DroneDto> mapListToDto(List<Drone> data);
}

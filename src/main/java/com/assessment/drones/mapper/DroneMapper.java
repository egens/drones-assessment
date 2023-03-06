package com.assessment.drones.mapper;

import com.assessment.drones.dto.DroneDto;
import com.assessment.drones.entity.Drone;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DroneMapper {

    Drone mapFromDto(DroneDto dto);
    DroneDto mapToDto(Drone dto);
    List<DroneDto> mapListToDto(List<Drone> dto);
}

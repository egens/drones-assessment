package com.assessment.drones.mapper;

import com.assessment.drones.dto.DroneDto;
import com.assessment.drones.entity.Drone;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DroneMapper {

    Drone mapFromDto(DroneDto dto);
}

package com.assessment.drones.service;

import com.assessment.drones.dto.DroneDto;
import com.assessment.drones.entity.Drone;
import com.assessment.drones.mapper.DroneMapper;
import com.assessment.drones.repository.DroneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class DroneService {

    private final DroneMapper droneMapper;
    private final DroneRepository droneRepository;
    private static final int LOADING_BATTERY_LIMIT = 25;

    public DroneDto registerDrone(DroneDto droneDto) {
        Drone drone = droneMapper.mapFromDto(droneDto);
        return droneMapper.mapToDto(droneRepository.save(drone));
    }

    public List<DroneDto> getDrones(boolean loadingAvailable) {
        Stream<Drone> droneStream = droneRepository.findAll().stream();
        if (loadingAvailable) {
            droneStream = droneStream.filter(d -> d.getBatteryCapacity() > LOADING_BATTERY_LIMIT);
        }
        return droneMapper.mapListToDto(droneStream.toList());
    }

    public Integer getBatteryLevel(String droneId) {
        Optional<Drone> drone = droneRepository.findById(droneId);
        if (drone.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return drone.get().getBatteryCapacity();
    }
}

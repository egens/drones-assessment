package com.assessment.drones.service;

import com.assessment.drones.dto.DroneDto;
import com.assessment.drones.dto.MedicationDto;
import com.assessment.drones.entity.Drone;
import com.assessment.drones.entity.DroneHistory;
import com.assessment.drones.repository.DroneHistoryRepository;
import com.assessment.drones.repository.DroneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class DroneService {

    private final DroneRepository droneRepository;
    private final DroneHistoryRepository droneHistoryRepository;
    private static final int LOADING_BATTERY_LIMIT = 25;

    public DroneDto registerDrone(DroneDto droneDto) {
        droneMapper.mapFromDto(drone);
        droneStore.put(drone.getSerialNumber(), drone);
        return drone;
    }

    public List<Drone> getDrones(boolean loadingAvailable) {
        Stream<Drone> droneStream = droneStore.values().stream();
        if (loadingAvailable) {
            droneStream = droneStream.filter(d -> d.getBatteryCapacity() > LOADING_BATTERY_LIMIT);
        }
        return droneStream.toList();
    }

    public Integer getBatteryLevel(String droneId) {
        return droneStore.get(droneId).getBatteryCapacity();
    }

    public List<MedicationDto> getDroneMedications(String droneId) {
        return List.of();//droneStore.get(droneId).getMedications();
    }

    public void loadMedications(String droneId, List<String> medicationCodes) {
        Drone drone = droneStore.get(droneId);
        // TODO get medications
        List<MedicationDto> medications = List.of();
        if (checkDroneWeightLimit(drone, medications)) {
//            drone.setMedications(List.of());
        } else {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private boolean checkDroneWeightLimit(Drone drone, List<MedicationDto> medications) {
        int newMedicationsWeight = medications.stream()
                .mapToInt(MedicationDto::getWeight)
                .sum();
        int droneMedicationsWeight = 0;
//        drone.getMedications().stream()
//                .mapToInt(MedicationDto::getWeight)
//                .sum();
        return drone.getWeightLimit() > droneMedicationsWeight + newMedicationsWeight;
    }

    /**
     * Introduce a periodic task to check drones battery levels and create history/audit event log for this.
     */
    @Scheduled(cron = "/5 * * * * *")
    private void droneHistory() {
        LocalDateTime time = LocalDateTime.now();
        List<DroneHistory> droneHistory = droneRepository.findAll().stream().map(d -> DroneHistory.builder()
                .uuid(UUID.randomUUID())
                .timestamp(time)
                .batteryCapacity(d.getBatteryCapacity())
                .build()).collect(Collectors.toList());
        droneHistoryRepository.saveAll(droneHistory);
    }
}

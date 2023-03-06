package com.assessment.drones.service;

import com.assessment.drones.dto.MedicationDto;
import com.assessment.drones.entity.Drone;
import com.assessment.drones.entity.DroneHistory;
import com.assessment.drones.entity.Medication;
import com.assessment.drones.mapper.DroneMapper;
import com.assessment.drones.mapper.MedicationMapper;
import com.assessment.drones.repository.DroneHistoryRepository;
import com.assessment.drones.repository.DroneRepository;
import com.assessment.drones.repository.MedicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MedicationService {

    private final MedicationMapper medicationMapper;
    private final DroneRepository droneRepository;
    private final MedicationRepository medicationRepository;

    public List<MedicationDto> getDroneMedications(String droneId) {
        Optional<Drone> drone = droneRepository.findById(droneId);
        if (drone.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return medicationMapper.mapListToDto(drone.get().getMedications());
    }

    public void loadMedications(String droneId, List<String> medicationCodes) {
        Optional<Drone> droneOptional = droneRepository.findById(droneId);
        if (droneOptional.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        Drone drone = droneOptional.get();
        List<Medication> medications = medicationRepository.findAllById(medicationCodes);
        if (!checkDroneWeightLimit(drone, medications))
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Drone weight limit exceeded.");
        drone.setMedications(medications);
        droneRepository.save(drone);
    }

    /**
     * Prevent the drone from being loaded with more weight that it can carry;
     */
    private boolean checkDroneWeightLimit(Drone drone, List<Medication> medications) {
        int newMedicationsWeight = medications.stream()
                .mapToInt(Medication::getWeight)
                .sum();
        int droneMedicationsWeight = drone.getMedications().stream()
                .mapToInt(Medication::getWeight)
                .sum();
        return drone.getWeightLimit() > droneMedicationsWeight + newMedicationsWeight;
    }
}

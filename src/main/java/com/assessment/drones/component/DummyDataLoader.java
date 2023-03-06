package com.assessment.drones.component;

import com.assessment.drones.entity.Drone;
import com.assessment.drones.entity.DroneModel;
import com.assessment.drones.entity.DroneState;
import com.assessment.drones.entity.Medication;
import com.assessment.drones.repository.DroneRepository;
import com.assessment.drones.repository.MedicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DummyDataLoader implements ApplicationRunner {

    private final DroneRepository droneRepository;
    private final MedicationRepository medicationRepository;

    public void run(ApplicationArguments args) {
        droneRepository.save(
                Drone.builder()
                        .serialNumber("1")
                        .model(DroneModel.LIGHTWEIGHT)
                        .weightLimit(1000)
                        .batteryCapacity(100)
                        .state(DroneState.IDLE)
                        .medications(List.of())
                        .build()
        );

        medicationRepository.save(
                Medication.builder()
                        .name("First")
                        .weight(100)
                        .code("1")
                        .imageUrl("example.com")
                        .build()
        );

        medicationRepository.save(
                Medication.builder()
                        .name("Second")
                        .weight(300)
                        .code("2")
                        .imageUrl("example.com")
                        .build()
        );

        medicationRepository.save(
                Medication.builder()
                        .name("Last")
                        .weight(1000)
                        .code("3")
                        .imageUrl("example.com")
                        .build()
        );
    }
}
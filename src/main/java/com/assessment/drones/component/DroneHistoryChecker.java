package com.assessment.drones.component;

import com.assessment.drones.entity.DroneHistory;
import com.assessment.drones.repository.DroneHistoryRepository;
import com.assessment.drones.repository.DroneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Introduce a periodic task to check drones battery levels and create history/audit event log for this.
 */
@Component
@RequiredArgsConstructor
public class DroneHistoryChecker {

    private final DroneRepository droneRepository;
    private final DroneHistoryRepository droneHistoryRepository;

    @Scheduled(cron = "* * * * * *")
    private void droneHistory() {
        LocalDateTime time = LocalDateTime.now();
        List<DroneHistory> droneHistory = droneRepository.findAll().stream().map(d -> DroneHistory.builder()
                .uuid(UUID.randomUUID())
                .timestamp(time)
                .batteryCapacity(d.getBatteryCapacity())
                .build()).toList();
        droneHistoryRepository.saveAll(droneHistory);
    }
}

package com.assessment.drones.repository;

import com.assessment.drones.entity.DroneHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DroneHistoryRepository extends JpaRepository<DroneHistory, String> {
}

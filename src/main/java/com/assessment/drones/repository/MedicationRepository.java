package com.assessment.drones.repository;

import com.assessment.drones.entity.Drone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationRepository extends JpaRepository<Drone, String> {
}

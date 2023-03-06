package com.assessment.drones.repository;

import com.assessment.drones.entity.Drone;
import com.assessment.drones.entity.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, String> {
}

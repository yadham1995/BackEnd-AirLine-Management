package com.airline.management.repository;

import com.airline.management.entity.AirlineMovement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirlineMovementRepository extends JpaRepository<AirlineMovement, Integer> {
}

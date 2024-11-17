package com.airline.management.repository;

import com.airline.management.entity.CarrierCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarrierCodeRepository extends JpaRepository<CarrierCode, Integer> {
}

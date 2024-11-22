package com.airline.management.repository;

import com.airline.management.entity.CarrierCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarrierCodeRepository extends JpaRepository<CarrierCode, Long> {
    Optional<CarrierCode> findByCode(String code);
}

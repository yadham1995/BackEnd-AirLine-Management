package com.airline.management.repository;

import com.airline.management.entity.SalesPerson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SalesPersonRepository extends JpaRepository<SalesPerson, Long> {
    Optional<SalesPerson> findBySalesPersonCode(String salesPersonCode);
}

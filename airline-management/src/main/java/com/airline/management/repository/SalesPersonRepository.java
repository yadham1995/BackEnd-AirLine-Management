package com.airline.management.repository;

import com.airline.management.entity.SalesPerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesPersonRepository extends JpaRepository<SalesPerson, Integer> {
}

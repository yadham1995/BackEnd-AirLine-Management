package com.airline.management.repository;

import com.airline.management.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("SELECT c FROM Customer c WHERE c.parentCustomer IS NULL")
    List<Customer> findParentCustomers();

    @Query("SELECT c FROM Customer c WHERE c.parentCustomer.id = :parentId")
    List<Customer> findSubCustomersByParentId(@Param("parentId") Long parentId);
}

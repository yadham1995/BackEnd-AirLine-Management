package com.airline.management.controller;

import com.airline.management.dto.CustomerDTO;
import com.airline.management.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO) {
        return ResponseEntity.ok(customerService.createCustomer(customerDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDTO) {
        return ResponseEntity.ok(customerService.updateCustomer(id, customerDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    // Parent and Sub-Customer APIs
    @GetMapping("/parents")
    public ResponseEntity<List<CustomerDTO>> getParentCustomers() {
        return ResponseEntity.ok(customerService.getParentCustomers());
    }

    @GetMapping("/subs/{parentId}")
    public ResponseEntity<List<CustomerDTO>> getSubCustomers(@PathVariable Long parentId) {
        return ResponseEntity.ok(customerService.getSubCustomers(parentId));
    }
}

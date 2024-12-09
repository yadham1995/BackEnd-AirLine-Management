package com.airline.management.controller;

import com.airline.management.dto.SalesPersonDTO;
import com.airline.management.service.SalesPersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales-persons")
@AllArgsConstructor
public class SalesPersonController {
    private final SalesPersonService salesPersonService;

    @PostMapping
    public ResponseEntity<SalesPersonDTO> createSalesPerson(@RequestBody SalesPersonDTO salesPersonDTO) {
        SalesPersonDTO createdSalesPerson = salesPersonService.createSalesPerson(salesPersonDTO);
        return ResponseEntity.ok(createdSalesPerson);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalesPersonDTO> getSalesPersonById(@PathVariable Long id) {
        SalesPersonDTO salesPerson = salesPersonService.getSalesPersonById(id);
        return ResponseEntity.ok(salesPerson);
    }

    @GetMapping
    public ResponseEntity<List<SalesPersonDTO>> getAllSalesPersons() {
        List<SalesPersonDTO> salesPersons = salesPersonService.getAllSalesPersons();
        return ResponseEntity.ok(salesPersons);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SalesPersonDTO> updateSalesPerson(
            @PathVariable Long id,
            @RequestBody SalesPersonDTO salesPersonDTO
    ) {
        SalesPersonDTO updatedSalesPerson = salesPersonService.updateSalesPerson(id, salesPersonDTO);
        return ResponseEntity.ok(updatedSalesPerson);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSalesPerson(@PathVariable Long id) {
        salesPersonService.deleteSalesPerson(id);
        return ResponseEntity.noContent().build();
    }
}

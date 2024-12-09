package com.airline.management.controller;

import com.airline.management.dto.CarrierCodeDTO;
import com.airline.management.service.CarrierCodeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carrier-codes")
@AllArgsConstructor
public class CarrierCodeController {

    private final CarrierCodeService carrierCodeService;

    @PostMapping
    public ResponseEntity<CarrierCodeDTO> addCarrierCode(@RequestBody CarrierCodeDTO carrierCodeDTO) {
        CarrierCodeDTO response = carrierCodeService.addCarrierCode(carrierCodeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarrierCodeDTO> updateCarrierCode(
            @PathVariable Long id,
            @RequestBody CarrierCodeDTO carrierCodeDTO) {
        CarrierCodeDTO response = carrierCodeService.updateCarrierCode(id, carrierCodeDTO);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarrierCode(@PathVariable Long id) {
        carrierCodeService.deleteCarrierCode(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarrierCodeDTO> getCarrierCodeById(@PathVariable Long id) {
        CarrierCodeDTO response = carrierCodeService.getCarrierCodeById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<CarrierCodeDTO>> getAllCarrierCodes() {
        List<CarrierCodeDTO> response = carrierCodeService.getAllCarrierCodes();
        return ResponseEntity.ok(response);
    }
}

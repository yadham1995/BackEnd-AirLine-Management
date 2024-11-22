package com.airline.management.controller;

import com.airline.management.dto.AirlineMovementRequestDTO;
import com.airline.management.dto.AirlineMovementResponseDTO;
import com.airline.management.service.AirlineMovementService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/airline-movements")
@AllArgsConstructor
public class AirlineMovementController {

    private final AirlineMovementService airlineMovementService;

    @PostMapping
    public ResponseEntity<AirlineMovementResponseDTO> addAirlineMovement(
            @RequestBody AirlineMovementRequestDTO airlineMovementRequestDTO) {
        AirlineMovementResponseDTO responseDTO = airlineMovementService.addAirlineMovement(airlineMovementRequestDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AirlineMovementResponseDTO> updateAirlineMovement(
            @PathVariable Long id, @RequestBody AirlineMovementRequestDTO airlineMovementRequestDTO) {
        AirlineMovementResponseDTO responseDTO = airlineMovementService.updateAirlineMovement(id, airlineMovementRequestDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAirlineMovement(@PathVariable Long id) {

        airlineMovementService.deleteAirlineMovement(id);
        return ResponseEntity.ok("Deleted Successfully");
    }
}

package com.airline.management.service;
import com.airline.management.dto.AirlineMovementRequestDTO;
import com.airline.management.dto.AirlineMovementResponseDTO;
import com.airline.management.entity.AirlineMovement;
import com.airline.management.exception.ResourceNotFoundException;
import com.airline.management.mapper.AirlineMovementMapper;
import com.airline.management.repository.AirlineMovementRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AirlineMovementService {

    private final AirlineMovementRepository airlineMovementRepository;
    private final AirlineMovementMapper airlineMovementMapper;

    public AirlineMovementResponseDTO addAirlineMovement(AirlineMovementRequestDTO airLineRequestDTO) {
        AirlineMovement airlineMovement = airlineMovementMapper.toEntity(airLineRequestDTO);
        AirlineMovement savedMovement = airlineMovementRepository.save(airlineMovement);
        return airlineMovementMapper.toResponseDTO(savedMovement);
    }

    public AirlineMovementResponseDTO updateAirlineMovement(Long id, AirlineMovementRequestDTO airLineRequestDTO) {
        AirlineMovement existingMovement = airlineMovementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Airline Movement not found with id: " + id));

        airlineMovementMapper.updateEntityFromDTO(airLineRequestDTO, existingMovement);
        AirlineMovement updatedMovement = airlineMovementRepository.save(existingMovement);
        return airlineMovementMapper.toResponseDTO(updatedMovement);
    }

    public void deleteAirlineMovement(Long id) {
        AirlineMovement existingMovement = airlineMovementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Airline Movement not found with id: " + id));
        airlineMovementRepository.delete(existingMovement);
    }
}

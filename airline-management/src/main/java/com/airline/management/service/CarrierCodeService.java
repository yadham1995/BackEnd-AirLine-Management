package com.airline.management.service;

import com.airline.management.dto.CarrierCodeDTO;
import com.airline.management.entity.CarrierCode;
import com.airline.management.exception.ResourceNotFoundException;
import com.airline.management.repository.CarrierCodeRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarrierCodeService {
    private final CarrierCodeRepository carrierCodeRepository;
    private final ModelMapper modelMapper;

    public CarrierCodeDTO addCarrierCode(CarrierCodeDTO carrierCodeDTO) {
        CarrierCode carrierCode = modelMapper.map(carrierCodeDTO, CarrierCode.class);
        CarrierCode savedCarrierCode = carrierCodeRepository.save(carrierCode);
        return modelMapper.map(savedCarrierCode, CarrierCodeDTO.class);
    }

    public CarrierCodeDTO updateCarrierCode(Long id, CarrierCodeDTO carrierCodeDTO) {
        CarrierCode existingCarrierCode = carrierCodeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CarrierCode not found with ID: " + id));
        modelMapper.map(carrierCodeDTO, existingCarrierCode);
        CarrierCode updatedCarrierCode = carrierCodeRepository.save(existingCarrierCode);
        return modelMapper.map(updatedCarrierCode, CarrierCodeDTO.class);
    }

    public void deleteCarrierCode(Long id) {
        if (!carrierCodeRepository.existsById(id)) {
            throw new ResourceNotFoundException("CarrierCode not found with ID: " + id);
        }
        carrierCodeRepository.deleteById(id);
    }

    public CarrierCodeDTO getCarrierCodeById(Long id) {
        CarrierCode carrierCode = carrierCodeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CarrierCode not found with ID: " + id));
        return modelMapper.map(carrierCode, CarrierCodeDTO.class);
    }

    public List<CarrierCodeDTO> getAllCarrierCodes() {
        List<CarrierCode> carrierCodes = carrierCodeRepository.findAll();
        return carrierCodes.stream()
                .map(carrierCode -> modelMapper.map(carrierCode, CarrierCodeDTO.class))
                .collect(Collectors.toList());
    }

}

package com.airline.management.service;

import com.airline.management.dto.SalesPersonDTO;
import com.airline.management.entity.SalesPerson;
import com.airline.management.exception.ResourceNotFoundException;
import com.airline.management.repository.SalesPersonRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SalesPersonService {
    private final SalesPersonRepository salesPersonRepository;
    private final ModelMapper modelMapper;

    public SalesPersonDTO createSalesPerson(SalesPersonDTO salesPersonDTO) {
        SalesPerson salesPerson = modelMapper.map(salesPersonDTO, SalesPerson.class);
        salesPerson = salesPersonRepository.save(salesPerson);
        return modelMapper.map(salesPerson, SalesPersonDTO.class);
    }

    public SalesPersonDTO getSalesPersonById(Long id) {
        SalesPerson salesPerson = salesPersonRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SalesPerson not found with ID: " + id));
        return modelMapper.map(salesPerson, SalesPersonDTO.class);
    }

    public List<SalesPersonDTO> getAllSalesPersons() {
        List<SalesPerson> salesPersons = salesPersonRepository.findAll();
        return salesPersons.stream()
                .map(salesPerson -> modelMapper.map(salesPerson, SalesPersonDTO.class))
                .collect(Collectors.toList());
    }

    public SalesPersonDTO updateSalesPerson(Long id, SalesPersonDTO salesPersonDTO) {
        SalesPerson salesPerson = salesPersonRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SalesPerson not found with ID: " + id));

        salesPerson.setSalesPersonCode(salesPersonDTO.getSalesPersonCode());
        salesPerson.setName(salesPersonDTO.getName());

        salesPerson = salesPersonRepository.save(salesPerson);
        return modelMapper.map(salesPerson, SalesPersonDTO.class);
    }

    public void deleteSalesPerson(Long id) {
        if (!salesPersonRepository.existsById(id)) {
            throw new ResourceNotFoundException("SalesPerson not found with ID: " + id);
        }
        salesPersonRepository.deleteById(id);
    }
}

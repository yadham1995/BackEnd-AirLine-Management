package com.airline.management.service;

import com.airline.management.dto.EmployeeDTO;
import com.airline.management.entity.Employee;
import com.airline.management.exception.ResourceNotFoundException;
import com.airline.management.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = modelMapper.map(employeeDTO, Employee.class);
        employee = employeeRepository.save(employee);
        return modelMapper.map(employee, EmployeeDTO.class);
    }

    public EmployeeDTO getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with ID: " + id));
        return modelMapper.map(employee, EmployeeDTO.class);
    }

    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(employee -> modelMapper.map(employee, EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with ID: " + id));

        employee.setCode(employeeDTO.getCode());
        employee.setName(employeeDTO.getName());

        employee = employeeRepository.save(employee);
        return modelMapper.map(employee, EmployeeDTO.class);
    }

    public void deleteEmployee(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new ResourceNotFoundException("Employee not found with ID: " + id);
        }
        employeeRepository.deleteById(id);
    }
}

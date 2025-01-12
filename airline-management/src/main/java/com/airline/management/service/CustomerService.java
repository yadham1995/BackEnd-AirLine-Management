package com.airline.management.service;

import com.airline.management.dto.CustomerDTO;
import com.airline.management.entity.Customer;
import com.airline.management.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        Customer customer = modelMapper.map(customerDTO, Customer.class);
        customer = customerRepository.save(customer);
        return modelMapper.map(customer, CustomerDTO.class);
    }

    public CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO) {
        Customer existingCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id " + id));
        existingCustomer.setCustomerNameEn(customerDTO.getCustomerNameEn());
        existingCustomer.setCustomerNameAr(customerDTO.getCustomerNameAr());
        customerRepository.save(existingCustomer);
        return modelMapper.map(existingCustomer, CustomerDTO.class);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    public CustomerDTO getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id " + id));
        return modelMapper.map(customer, CustomerDTO.class);
    }

    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll().stream()
                .map(customer -> modelMapper.map(customer, CustomerDTO.class))
                .toList();
    }

    // Parent and Sub-Customer APIs
    public List<CustomerDTO> getParentCustomers() {
        return customerRepository.findParentCustomers().stream()
                .map(customer -> modelMapper.map(customer, CustomerDTO.class))
                .toList();
    }

    public List<CustomerDTO> getSubCustomers(Long parentId) {
        return customerRepository.findSubCustomersByParentId(parentId).stream()
                .map(customer -> modelMapper.map(customer, CustomerDTO.class))
                .toList();
    }
}

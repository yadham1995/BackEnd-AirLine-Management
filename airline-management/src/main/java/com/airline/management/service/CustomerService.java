package com.airline.management.service;

import com.airline.management.dto.CustomerDTO;
import com.airline.management.entity.Customer;
import com.airline.management.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        Customer customer = modelMapper.map(customerDTO, Customer.class);

        // Handle parentCustomer mapping
        if (customerDTO.getParentCustomerId() != null) {
            Customer parentCustomer = customerRepository.findById(customerDTO.getParentCustomerId())
                    .orElseThrow(() -> new RuntimeException("Parent customer not found with id " + customerDTO.getParentCustomerId()));
            customer.setParentCustomer(parentCustomer);
        }

        customer = customerRepository.save(customer);
        return mapToDTO(customer);
    }

    public CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO) {
        Customer existingCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id " + id));

        // Update basic fields
        existingCustomer.setCustomerNameEn(customerDTO.getCustomerNameEn());
        existingCustomer.setCustomerNameAr(customerDTO.getCustomerNameAr());

        // Handle parentCustomer mapping
        if (customerDTO.getParentCustomerId() != null) {
            Customer parentCustomer = customerRepository.findById(customerDTO.getParentCustomerId())
                    .orElseThrow(() -> new RuntimeException("Parent customer not found with id " + customerDTO.getParentCustomerId()));
            existingCustomer.setParentCustomer(parentCustomer);
        } else {
            existingCustomer.setParentCustomer(null);
        }

        customerRepository.save(existingCustomer);
        return mapToDTO(existingCustomer);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    public CustomerDTO getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id " + id));
        return mapToDTO(customer);
    }

    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // Parent and Sub-Customer APIs
    public List<CustomerDTO> getParentCustomers() {
        return customerRepository.findParentCustomers().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public List<CustomerDTO> getSubCustomers(Long parentId) {
        return customerRepository.findSubCustomersByParentId(parentId).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // Helper method to map Customer to CustomerDTO
    private CustomerDTO mapToDTO(Customer customer) {
        CustomerDTO customerDTO = modelMapper.map(customer, CustomerDTO.class);

        // Map parentCustomerId
        if (customer.getParentCustomer() != null) {
            customerDTO.setParentCustomerId(customer.getParentCustomer().getId());
        }

        // Map subCustomerIds
        if (customer.getSubCustomers() != null && !customer.getSubCustomers().isEmpty()) {
            List<Long> subCustomerIds = customer.getSubCustomers().stream()
                    .map(Customer::getId)
                    .collect(Collectors.toList());
            customerDTO.setSubCustomerIds(subCustomerIds);
        }

        return customerDTO;
    }
}

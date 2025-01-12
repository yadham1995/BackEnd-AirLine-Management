package com.airline.management.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class CustomerDTO {
    private Long id;
    private String customerNameEn;
    private String customerNameAr;
    private Long parentCustomerId; // Reference to the parent customer
    private List<Long> subCustomerIds; // List of IDs for sub-customers
}

package com.airline.management.dto;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;


@Getter
@Setter
@ToString
public class AirlineMovementRequestDTO {
    private Integer serialNumber;
    private String gds; // Amadeus, Saber, etc.
    private LocalDate issueDate;
    private String ticketForm; // BSP, VCH, STK
    private String passengerName;
    private String payForm; // Cash, Credit
    private String route;
    private String remarks;
    private String destination;
    private BigDecimal savingAmount;
    private String savingReason;
    private LocalDate travelDate;
    private LocalDate returnDate;
    private String creditCardNo;
    private String personalId;
    private String userName; // Reference to User
    private String carrierCode; // Reference to CarrierCode
    private String customerCode; // Reference to Customer
    private String salesPersonCode; // Reference to SalesPerson
}

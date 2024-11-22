package com.airline.management.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@ToString
public class AirlineMovementResponseDTO {
    private Long id; // Unique identifier for the airline movement
    private Integer serialNumber;
    private String gds;
    private LocalDate issueDate;
    private String carrierCodeName; // Human-readable name for CarrierCode
    private String ticketForm;
    private String passengerName;
    private String customerName; // Human-readable name for Customer
    private String payForm;
    private String route;
    private String remarks;
    private String destination;
    private BigDecimal savingAmount;
    private String savingReason;
    private LocalDate travelDate;
    private LocalDate returnDate;
    private String creditCardNo; // (Masked for security if needed)
    private String personalId;
    private String salesPersonName; // Human-readable name for SalesPerson
    private String userName;
}

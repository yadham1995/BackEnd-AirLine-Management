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
    private Integer ticketNum;
    private Integer serialNumber;
    private String gds;
    private LocalDate issueDate;
    private String ticketForm;
    private String passengerName;
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
    private String iata;
    private String invoiceNum;
    private String airLineTicketType;
    private String airLineTicketSettlement;
    private Long carrierCodeId; // Reference to CarrierCode
    private Long customerId; // Reference to Customer
    private Long salesPersonId; // Reference to SalesPerson
    private Long employeeId; // Reference to Employee
    private Long fileNumTypeId; // Reference to fileNoType
    private String userName;
}

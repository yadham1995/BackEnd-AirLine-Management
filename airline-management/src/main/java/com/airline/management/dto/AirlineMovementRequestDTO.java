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
    private Integer ticketNum;
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
    private String iata;
    private String invoiceNum;
    private String airLineTicketType;
    private String airLineTicketSettlement;
    private String userName; // Reference to User
    private Long carrierCodeId; // Reference to CarrierCode
    private Long parentCustomerId; // Reference to the parent customer
    private Long subCustomerId;    // Reference to the sub-customer
    private Long salesPersonId; // Reference to SalesPerson
    private Long employeeId; // Reference to Employee
    private Long fileNumTypeId; // Reference to fileNoType
}

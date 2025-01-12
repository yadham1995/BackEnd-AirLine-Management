package com.airline.management.entity;


import com.airline.management.dto.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@Table(name="AirlineMovement")
@Entity
@Getter
@Setter
@ToString
public class AirlineMovement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ticket_Num", nullable = false, unique = true)
    private Integer ticketNum;

    @Column(name = "serial_number", nullable = false, unique = true)
    private Integer serialNumber;

    @Enumerated(EnumType.STRING)
    private GDS gds;

    @Column(name = "issue_date")
    private Date issueDate;

    @Enumerated(EnumType.STRING)
    private TicketForm ticketForm;

    @Column(name = "passenger_name")
    private String passengerName;

    @Enumerated(EnumType.STRING)
    private PayForm payForm;

    private String route;

    private String remarks;

    private String destination;

    @Column(name = "saving_amount")
    private BigDecimal savingAmount;

    @Column(name = "saving_reason")
    private String savingReason;

    @Column(name = "travel_date")
    private Date travelDate;

    @Column(name = "return_date")
    private Date returnDate;

    @Column(name = "credit_card_no")
    private String creditCardNo;

    @Column(name = "personal_id")
    private String personalId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "carrier_code_id")
    private CarrierCode carrierCode;

    // Reference to the parent customer
    @ManyToOne
    @JoinColumn(name = "parent_customer_id")
    private Customer parentCustomer;

    // Reference to the sub-customer (nullable if not applicable)
    @ManyToOne
    @JoinColumn(name = "sub_customer_id")
    private Customer subCustomer;

    @ManyToOne
    @JoinColumn(name = "sales_person_id")
    private SalesPerson salesPerson;

    @Column(name = "iata")
    private String iata;

    @Enumerated(EnumType.STRING)
    private AirLineTicketType airLineTicketType;

    @Column(name = "invoice_num")
    private String invoiceNum;

    @Enumerated(EnumType.STRING)
    private AirLineTicketSettlement airLineTicketSettlement;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "file_type_id")
    private FileNoType fileNoType;

}


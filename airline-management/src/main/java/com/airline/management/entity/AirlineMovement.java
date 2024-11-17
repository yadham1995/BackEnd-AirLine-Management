package com.airline.management.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
public class AirlineMovement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "serial_number", nullable = false, unique = true)
    private Integer serialNumber;

    @Enumerated(EnumType.STRING)
    private GDS gds;

    @Column(name = "issue_date")
    private Date issueDate;

    @ManyToOne
    @JoinColumn(name = "carrier_code_id")
    private CarrierCode carrierCode;

    @Enumerated(EnumType.STRING)
    private TicketForm ticketForm;

    @Column(name = "passenger_name")
    private String passengerName;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

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
    @JoinColumn(name = "sales_person_id")
    private SalesPerson salesPerson;

    public enum GDS {
        Amadeus, Saber, Galileo, WorldSpan, Other
    }

    public enum TicketForm {
        BSP, VCH, STK
    }

    public enum PayForm {
        Cash, Credit
    }
}


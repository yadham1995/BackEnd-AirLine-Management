package com.airline.management.entity;

import com.airline.management.dto.TicketType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Entity
@Table(name = "Ticket")
@Getter
@Setter
@ToString
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ticket_number", nullable = false, unique = true)
    private Long ticketNumber;

    @ManyToOne
    @JoinColumn(name = "carrier_code_id")
    private Account carrierCode;

    @Column(name = "qr_code")
    private String qrCode;

    @Column(name = "fare_basis")
    private String fareBasis;

    @Column(name = "basic_fare")
    private BigDecimal basicFare;

    @Column(name = "total_fare")
    private BigDecimal totalFare;

    @Column(name = "passenger_name", nullable = false)
    private String passengerName;

    @Column(name = "bonus_points")
    private Integer bonusPoints;

    @Enumerated(EnumType.STRING)
    private TicketType type;

    @ManyToOne
    @JoinColumn(name = "airline_movement_id")
    private AirlineMovement airlineMovement;
}

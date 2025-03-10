package com.airline.management.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TicketDTO {
    private Long id;
    private Long ticketNumber;
    private Long carrierCodeId;
    private String qrCode;
    private String fareBasis;
    private BigDecimal basicFare;
    private BigDecimal totalFare;
    private String passengerName;
    private Integer bonusPoints;
    private Integer type;  // Will be converted to/from TicketType Enum
    private Long airlineMovementId;
}

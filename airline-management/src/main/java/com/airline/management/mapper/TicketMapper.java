package com.airline.management.mapper;

import com.airline.management.dto.TicketDTO;
import com.airline.management.dto.TicketType;
import com.airline.management.entity.Ticket;
import com.airline.management.entity.Account;
import com.airline.management.entity.AirlineMovement;

public class TicketMapper {

    public static TicketDTO toDTO(Ticket ticket) {
        return new TicketDTO(
                ticket.getId(),
                ticket.getTicketNumber(),
                ticket.getCarrierCode() != null ? ticket.getCarrierCode().getId() : null,
                ticket.getQrCode(),
                ticket.getFareBasis(),
                ticket.getBasicFare(),
                ticket.getTotalFare(),
                ticket.getPassengerName(),
                ticket.getBonusPoints(),
                ticket.getType() != null ? ticket.getType().getValue() : null,
                ticket.getAirlineMovement() != null ? ticket.getAirlineMovement().getId() : null
        );
    }

    public static Ticket toEntity(TicketDTO dto, Account carrierCode, AirlineMovement airlineMovement) {
        Ticket ticket = new Ticket();
        ticket.setTicketNumber(dto.getTicketNumber());
        ticket.setCarrierCode(carrierCode);
        ticket.setQrCode(dto.getQrCode());
        ticket.setFareBasis(dto.getFareBasis());
        ticket.setBasicFare(dto.getBasicFare());
        ticket.setTotalFare(dto.getTotalFare());
        ticket.setPassengerName(dto.getPassengerName());
        ticket.setBonusPoints(dto.getBonusPoints());
        ticket.setType(TicketType.fromValue(dto.getType())); // Convert Integer to Enum
        ticket.setAirlineMovement(airlineMovement);
        return ticket;
    }
}

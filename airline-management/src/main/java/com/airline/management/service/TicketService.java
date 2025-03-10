package com.airline.management.service;

import com.airline.management.dto.TicketDTO;
import com.airline.management.dto.TicketType;
import com.airline.management.entity.Account;
import com.airline.management.entity.AirlineMovement;
import com.airline.management.entity.Ticket;
import com.airline.management.mapper.TicketMapper;
import com.airline.management.repository.AccountRepository;
import com.airline.management.repository.AirlineMovementRepository;
import com.airline.management.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final AccountRepository accountRepository;
    private final AirlineMovementRepository airlineMovementRepository;

    public TicketService(TicketRepository ticketRepository, AccountRepository accountRepository, AirlineMovementRepository airlineMovementRepository) {
        this.ticketRepository = ticketRepository;
        this.accountRepository = accountRepository;
        this.airlineMovementRepository = airlineMovementRepository;
    }

    public List<TicketDTO> getTicketsByAirlineMovement(Long airlineMovementId) {
        List<Ticket> tickets = ticketRepository.findByAirlineMovementId(airlineMovementId);
        return tickets.stream().map(TicketMapper::toDTO).collect(Collectors.toList());
    }

    public TicketDTO createTicket(TicketDTO ticketDTO) {
        // Fetch foreign key references
        Account carrierCode = new Account();
        carrierCode.setId(ticketDTO.getCarrierCodeId());
        AirlineMovement airlineMovement = new AirlineMovement();
        airlineMovement.setId(ticketDTO.getAirlineMovementId());

        // Convert DTO to Entity
        Ticket ticket = TicketMapper.toEntity(ticketDTO, carrierCode, airlineMovement);
        Ticket savedTicket = ticketRepository.save(ticket);
        return TicketMapper.toDTO(savedTicket);
    }

    public TicketDTO updateTicket(Long ticketId, TicketDTO ticketDTO) {
        Ticket existingTicket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found with id: " + ticketId));

        // Fetch foreign key references
        Account carrierCode = new Account();
        carrierCode.setId(ticketDTO.getCarrierCodeId());
        AirlineMovement airlineMovement = new AirlineMovement();
        airlineMovement.setId(ticketDTO.getAirlineMovementId());

        // Update existing ticket
        existingTicket.setTicketNumber(ticketDTO.getTicketNumber() != null ? ticketDTO.getTicketNumber() : existingTicket.getTicketNumber());
        existingTicket.setCarrierCode(carrierCode.getId() != null ? carrierCode : existingTicket.getCarrierCode());
        existingTicket.setQrCode(ticketDTO.getQrCode() != null ? ticketDTO.getQrCode() : existingTicket.getQrCode());
        existingTicket.setFareBasis(ticketDTO.getFareBasis() != null ? ticketDTO.getFareBasis() : existingTicket.getFareBasis());
        existingTicket.setBasicFare(ticketDTO.getBasicFare() != null ? ticketDTO.getBasicFare() : existingTicket.getBasicFare());
        existingTicket.setTotalFare(ticketDTO.getTotalFare() != null ? ticketDTO.getTotalFare() : existingTicket.getTotalFare());
        existingTicket.setPassengerName(ticketDTO.getPassengerName() != null ? ticketDTO.getPassengerName() : existingTicket.getPassengerName());
        existingTicket.setBonusPoints(ticketDTO.getBonusPoints() != null ? ticketDTO.getBonusPoints() : existingTicket.getBonusPoints());
        existingTicket.setType(ticketDTO.getType() != null ? TicketType.fromValue(ticketDTO.getType()) : existingTicket.getType());
        existingTicket.setAirlineMovement(airlineMovement.getId() != null ? airlineMovement : existingTicket.getAirlineMovement());

        // Save and return updated DTO
        Ticket updatedTicket = ticketRepository.save(existingTicket);
        return TicketMapper.toDTO(updatedTicket);
    }


    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }
}

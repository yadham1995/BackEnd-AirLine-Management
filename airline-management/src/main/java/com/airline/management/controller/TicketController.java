package com.airline.management.controller;

import com.airline.management.dto.TicketDTO;
import com.airline.management.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/airline-movement/{airlineMovementId}")
    public ResponseEntity<List<TicketDTO>> getTicketsByAirlineMovement(@PathVariable Long airlineMovementId) {
        return ResponseEntity.ok(ticketService.getTicketsByAirlineMovement(airlineMovementId));
    }

    @PostMapping
    public ResponseEntity<TicketDTO> createTicket(@RequestBody TicketDTO ticketDTO) {
        return ResponseEntity.ok(ticketService.createTicket(ticketDTO));
    }

    @PutMapping("/{ticketId}")
    public ResponseEntity<TicketDTO> updateTicket(@PathVariable Long ticketId, @RequestBody TicketDTO ticketDTO) {
        return ResponseEntity.ok(ticketService.updateTicket(ticketId, ticketDTO));
    }

}

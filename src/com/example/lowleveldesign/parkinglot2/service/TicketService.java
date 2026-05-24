package com.example.lowleveldesign.parkinglot2.service;

import com.example.lowleveldesign.parkinglot2.domain.Ticket;
import com.example.lowleveldesign.parkinglot2.domain.Vehicle;
import com.example.lowleveldesign.parkinglot2.repository.TicketRepository;

import java.util.Optional;
import java.util.UUID;

public class TicketService {
    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket generateTicket(Vehicle vehicle, UUID slotId) {
        Ticket ticket = new Ticket(vehicle.getId(), slotId);
        ticketRepository.save(ticket);
        return ticket;
    }

    public Optional<Ticket> getTicket(UUID ticketId) {
        return ticketRepository.findById(ticketId);
    }

    public boolean deactivateTicket(UUID ticketId) {
        Optional<Ticket> ticket = ticketRepository.findById(ticketId);
        ticket.ifPresent(Ticket::deactivate);
        return ticket.isPresent();
    }
}

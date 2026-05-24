package com.example.lowleveldesign.parkinglot2.repository;

import com.example.lowleveldesign.parkinglot2.domain.Ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class TicketRepository {
    private final List<Ticket> tickets = new ArrayList<>();

    public void save(Ticket ticket) {
        tickets.add(ticket);
    }

    public Optional<Ticket> findById(UUID id) {
        return tickets.stream().filter(ticket -> ticket.getId().equals(id)).findFirst();
    }

    public List<Ticket> findAll() {
        return new ArrayList<>(tickets);
    }
}

package com.example.lowleveldesign.parkinglot2.controller;

import com.example.lowleveldesign.parkinglot2.domain.ParkingSlot;
import com.example.lowleveldesign.parkinglot2.domain.Ticket;
import com.example.lowleveldesign.parkinglot2.domain.Vehicle;
import com.example.lowleveldesign.parkinglot2.domain.VehicleType;
import com.example.lowleveldesign.parkinglot2.service.SlotService;
import com.example.lowleveldesign.parkinglot2.service.TicketService;

import java.util.Optional;
import java.util.UUID;

public class EntryController {
    private final TicketService ticketService;
    private final SlotService slotService;

    public EntryController(TicketService ticketService, SlotService slotService) {
        this.ticketService = ticketService;
        this.slotService = slotService;
    }

    public EntryResult enterVehicle(String licensePlate, VehicleType vehicleType) {
        Optional<ParkingSlot> slotOptional = slotService.allocateSlot(vehicleType);
        if (!slotOptional.isPresent()) {
            return new EntryResult(false, null, null, "No available slots for " + vehicleType);
        }

        Vehicle vehicle = new Vehicle(licensePlate, vehicleType);
        Ticket ticket = ticketService.generateTicket(vehicle, slotOptional.get().getId());
        return new EntryResult(true, ticket.getId(), slotOptional.get().getId(), "Entry successful");
    }

    public static class EntryResult {
        private final boolean success;
        private final UUID ticketId;
        private final UUID slotId;
        private final String message;

        public EntryResult(boolean success, UUID ticketId, UUID slotId, String message) {
            this.success = success;
            this.ticketId = ticketId;
            this.slotId = slotId;
            this.message = message;
        }

        public boolean isSuccess() {
            return success;
        }

        public UUID getTicketId() {
            return ticketId;
        }

        public UUID getSlotId() {
            return slotId;
        }

        public String getMessage() {
            return message;
        }

        @Override
        public String toString() {
            return "EntryResult{" +
                    "success=" + success +
                    ", ticketId=" + ticketId +
                    ", slotId=" + slotId +
                    ", message='" + message + '\'' +
                    '}';
        }
    }
}

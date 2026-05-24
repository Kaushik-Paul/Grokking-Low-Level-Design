package com.example.lowleveldesign.parkinglot2.controller;

import com.example.lowleveldesign.parkinglot2.domain.Receipt;
import com.example.lowleveldesign.parkinglot2.domain.Ticket;
import com.example.lowleveldesign.parkinglot2.domain.VehicleType;
import com.example.lowleveldesign.parkinglot2.service.TicketService;
import com.example.lowleveldesign.parkinglot2.service.PricingService;
import com.example.lowleveldesign.parkinglot2.service.PaymentService;
import com.example.lowleveldesign.parkinglot2.service.ReceiptService;
import com.example.lowleveldesign.parkinglot2.service.SlotService;

import java.util.Optional;
import java.util.UUID;

public class ExitController {
    private final TicketService ticketService;
    private final PricingService pricingService;
    private final PaymentService paymentService;
    private final ReceiptService receiptService;
    private final SlotService slotService;

    public ExitController(TicketService ticketService,
                          PricingService pricingService,
                          PaymentService paymentService,
                          ReceiptService receiptService,
                          SlotService slotService) {
        this.ticketService = ticketService;
        this.pricingService = pricingService;
        this.paymentService = paymentService;
        this.receiptService = receiptService;
        this.slotService = slotService;
    }

    public ExitResult exitVehicle(UUID ticketId, VehicleType vehicleType) {
        Optional<Ticket> ticketOptional = ticketService.getTicket(ticketId);
        if (!ticketOptional.isPresent()) {
            return new ExitResult(false, null, 0.0, "Ticket not found");
        }

        Ticket ticket = ticketOptional.get();
        if (!ticket.isActive()) {
            return new ExitResult(false, null, 0.0, "Ticket already inactive");
        }

        double fee = pricingService.calculateFee(ticket, vehicleType);
        boolean paid = paymentService.processPaymentWithRetry(ticket.getId(), fee, 3);
        if (!paid) {
            return new ExitResult(false, null, fee, "Payment failed");
        }

        Receipt receipt = receiptService.generateReceipt(ticket, fee);
        receiptService.markReceiptAsPaid(receipt);
        slotService.releaseSlot(ticket.getSlotId());
        ticketService.deactivateTicket(ticket.getId());

        return new ExitResult(true, receipt.getId(), fee, "Exit successful");
    }

    public String generateReceiptText(UUID ticketId, VehicleType vehicleType) {
        Optional<Ticket> ticketOptional = ticketService.getTicket(ticketId);
        if (!ticketOptional.isPresent()) {
            return "Ticket not found";
        }
        Ticket ticket = ticketOptional.get();
        double fee = pricingService.calculateFee(ticket, vehicleType);
        Receipt receipt = receiptService.generateReceipt(ticket, fee);
        return receiptService.generateReceiptText(receipt, ticket);
    }

    public static class ExitResult {
        private final boolean success;
        private final UUID receiptId;
        private final double fee;
        private final String message;

        public ExitResult(boolean success, UUID receiptId, double fee, String message) {
            this.success = success;
            this.receiptId = receiptId;
            this.fee = fee;
            this.message = message;
        }

        public boolean isSuccess() {
            return success;
        }

        public UUID getReceiptId() {
            return receiptId;
        }

        public double getFee() {
            return fee;
        }

        public String getMessage() {
            return message;
        }

        @Override
        public String toString() {
            return "ExitResult{" +
                    "success=" + success +
                    ", receiptId=" + receiptId +
                    ", fee=" + fee +
                    ", message='" + message + '\'' +
                    '}';
        }
    }
}

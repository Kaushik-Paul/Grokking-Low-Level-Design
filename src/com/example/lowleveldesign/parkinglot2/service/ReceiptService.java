package com.example.lowleveldesign.parkinglot2.service;

import com.example.lowleveldesign.parkinglot2.domain.PaymentStatus;
import com.example.lowleveldesign.parkinglot2.domain.Receipt;
import com.example.lowleveldesign.parkinglot2.domain.Ticket;

public class ReceiptService {
    public Receipt generateReceipt(Ticket ticket, double totalFee) {
        return new Receipt(ticket.getId(), totalFee);
    }

    public void markReceiptAsPaid(Receipt receipt) {
        receipt.setPaymentStatus(PaymentStatus.SUCCESS);
    }

    public String generateReceiptText(Receipt receipt, Ticket ticket) {
        return "Receipt ID: " + receipt.getId() + System.lineSeparator() +
                "Ticket ID: " + ticket.getId() + System.lineSeparator() +
                "Entry Time: " + ticket.getEntryTime() + System.lineSeparator() +
                "Exit Time: " + receipt.getExitTime() + System.lineSeparator() +
                "Total Fee: " + receipt.getTotalFee() + System.lineSeparator() +
                "Payment Status: " + receipt.getPaymentStatus();
    }
}

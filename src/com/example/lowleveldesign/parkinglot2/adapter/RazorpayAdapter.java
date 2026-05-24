package com.example.lowleveldesign.parkinglot2.adapter;

import java.util.Random;
import java.util.UUID;

public class RazorpayAdapter implements PaymentGatewayAdapter {
    private final Random random = new Random();

    @Override
    public boolean pay(UUID ticketId, double amount) {
        System.out.println("[ADAPTER] Razorpay processing payment for ticket " + ticketId + ", amount: " + amount);
        return random.nextInt(100) < 90;
    }
}

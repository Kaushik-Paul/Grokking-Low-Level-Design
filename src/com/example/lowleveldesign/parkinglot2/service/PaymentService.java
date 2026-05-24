package com.example.lowleveldesign.parkinglot2.service;

import com.example.lowleveldesign.parkinglot2.adapter.PaymentGatewayAdapter;
import com.example.lowleveldesign.parkinglot2.domain.Payment;
import com.example.lowleveldesign.parkinglot2.domain.PaymentGateway;
import com.example.lowleveldesign.parkinglot2.domain.PaymentStatus;
import com.example.lowleveldesign.parkinglot2.repository.PaymentRepository;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final Map<PaymentGateway, PaymentGatewayAdapter> paymentAdapters = new LinkedHashMap<>();

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public void registerAdapter(PaymentGateway gateway, PaymentGatewayAdapter adapter) {
        paymentAdapters.put(gateway, adapter);
    }

    public boolean processPaymentWithRetry(UUID ticketId, double amount, int maxRetries) {
        for (Map.Entry<PaymentGateway, PaymentGatewayAdapter> entry : paymentAdapters.entrySet()) {
            Payment payment = new Payment(ticketId, amount, entry.getKey());
            for (int attempt = 1; attempt <= maxRetries; attempt++) {
                boolean success = entry.getValue().pay(ticketId, amount);
                if (success) {
                    payment.setStatus(PaymentStatus.SUCCESS);
                    paymentRepository.save(payment);
                    return true;
                }
            }
            payment.setStatus(PaymentStatus.FAILED);
            paymentRepository.save(payment);
        }
        return false;
    }
}

package com.example.lowleveldesign.parkinglot2.repository;

import com.example.lowleveldesign.parkinglot2.domain.Payment;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class PaymentRepository {
    private final List<Payment> payments = new ArrayList<>();

    public void save(Payment payment) {
        payments.add(payment);
    }

    public Optional<Payment> findById(UUID id) {
        return payments.stream().filter(payment -> payment.getId().equals(id)).findFirst();
    }

    public List<Payment> findAll() {
        return new ArrayList<>(payments);
    }
}

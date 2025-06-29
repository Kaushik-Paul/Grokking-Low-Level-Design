package com.example.lowleveldesign.inventorymanagementsystem.payment;

public class Payment {
    private PaymentMode paymentMode;

    public Payment(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    public boolean makePayment() {
        return this.paymentMode.makePayment();
    }
}

package com.example.lowleveldesign.inventorymanagementsystem.payment;

public class UpiPaymentMode implements PaymentMode {
    @Override
    public boolean makePayment() {
        return true;
    }
}

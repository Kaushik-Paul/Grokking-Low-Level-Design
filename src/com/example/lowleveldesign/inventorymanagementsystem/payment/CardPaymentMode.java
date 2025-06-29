package com.example.lowleveldesign.inventorymanagementsystem.payment;

public class CardPaymentMode implements PaymentMode{
    @Override
    public boolean makePayment() {
        return true;
    }
}

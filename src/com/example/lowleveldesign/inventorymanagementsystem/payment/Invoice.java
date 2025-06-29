package com.example.lowleveldesign.inventorymanagementsystem.payment;

import com.example.lowleveldesign.inventorymanagementsystem.order.Order;

public class Invoice {
    private int totalItemPrice;
    private int totalTax;
    private int totalFinalPrice;

    public void generateInvoice(Order order) {
        this.totalItemPrice = 200;
        this.totalTax = 20;
        this.totalFinalPrice = 220;

    }
}

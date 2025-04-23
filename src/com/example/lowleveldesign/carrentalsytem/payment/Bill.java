package com.example.lowleveldesign.carrentalsytem.payment;

import com.example.lowleveldesign.carrentalsytem.system.Reservation;

public class Bill {

    private Reservation reservation;
    private double totalBillAmount;
    private boolean isBillPaid;

    public Bill(Reservation reservation) {
        this.reservation = reservation;
        this.totalBillAmount = computeBillAmount();
        isBillPaid = false;
    }

    private double computeBillAmount(){
        return 100.0;
    }

}

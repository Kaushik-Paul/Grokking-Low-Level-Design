package com.example.lowleveldesign.parkinglot.parkinglot;

import com.example.lowleveldesign.parkinglot.payment.Payment;
import com.example.lowleveldesign.parkinglot.vehicle.Vehicle;

import java.util.Date;

public class ParkingTicket {
    private int ticketNo;
    private Date timestamp;
    private Date exit;
    private double amount;
    private boolean status;

    // Following are the instances of their respective classes
    private Vehicle vehicle;
    private Payment payment;
    private Entrance entrance;
    private Exit exitIns;
}

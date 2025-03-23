package com.example.lowleveldesign.parkinglot.vehicle;

import com.example.lowleveldesign.parkinglot.parkinglot.ParkingTicket;

public abstract class Vehicle {
    private int licenceNo;
    public abstract void assignTicket(ParkingTicket ticket);
}


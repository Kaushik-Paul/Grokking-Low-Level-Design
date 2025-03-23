package com.example.lowleveldesign.parkinglot.parkingslot;

import com.example.lowleveldesign.parkinglot.vehicle.Vehicle;

public class Motorcycle extends ParkingSpot{
    @Override
    public boolean assignVehicle(Vehicle vehicle) {
        return false;
    }
}

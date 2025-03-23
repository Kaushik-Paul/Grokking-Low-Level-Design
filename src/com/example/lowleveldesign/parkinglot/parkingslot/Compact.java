package com.example.lowleveldesign.parkinglot.parkingslot;

import com.example.lowleveldesign.parkinglot.vehicle.Vehicle;

public class Compact extends ParkingSpot{
    @Override
    public boolean assignVehicle(Vehicle vehicle) {
        return false;
    }
}

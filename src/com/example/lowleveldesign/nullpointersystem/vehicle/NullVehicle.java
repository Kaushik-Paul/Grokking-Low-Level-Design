package com.example.lowleveldesign.nullpointersystem.vehicle;

public class NullVehicle implements Vehicle {
    @Override
    public int getTankCapacity() {
        return 0;
    }

    @Override
    public int getSeatCapacity() {
        return 0;
    }
}

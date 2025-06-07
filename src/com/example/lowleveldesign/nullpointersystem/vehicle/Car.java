package com.example.lowleveldesign.nullpointersystem.vehicle;

public class Car implements Vehicle {
    @Override
    public int getTankCapacity() {
        return 40;
    }

    @Override
    public int getSeatCapacity() {
        return 5;
    }
}

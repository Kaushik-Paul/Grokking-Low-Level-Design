package com.example.lowleveldesign.nullpointersystem.vehicle;

public class Motorcycle implements Vehicle {
    @Override
    public int getTankCapacity() {
        return 20;
    }

    @Override
    public int getSeatCapacity() {
        return 2;
    }
}

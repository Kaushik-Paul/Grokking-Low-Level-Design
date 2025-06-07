package com.example.lowleveldesign.nullpointersystem;

import com.example.lowleveldesign.nullpointersystem.vehicle.Vehicle;
import com.example.lowleveldesign.nullpointersystem.vehicle.VehicleFactory;

public class Main {

    public static void main(String[] args) {
        Vehicle vehicle = VehicleFactory.getVehicle("boat");
        printVehicleDetails(vehicle);
    }

    public static void printVehicleDetails(Vehicle vehicle) {
        System.out.println("Seating Capacity: " + vehicle.getSeatCapacity());
        System.out.println("Tank Capacity: " + vehicle.getTankCapacity());
    }
}

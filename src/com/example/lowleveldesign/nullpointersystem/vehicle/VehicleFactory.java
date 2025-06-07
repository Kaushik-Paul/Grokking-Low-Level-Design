package com.example.lowleveldesign.nullpointersystem.vehicle;

public class VehicleFactory {

    public static Vehicle getVehicle(String vehicleType) {
        if ("car".equals(vehicleType)) {
            return new Car();
        }
        if ("motorcycle".equals(vehicleType)) {
            return new Motorcycle();
        }
        return new NullVehicle();
    }
}

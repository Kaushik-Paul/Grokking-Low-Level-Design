package com.example.lowleveldesign.carrentalsytem.system;

import com.example.lowleveldesign.carrentalsytem.product.Vehicle;
import com.example.lowleveldesign.carrentalsytem.product.VehicleType;

import java.util.List;

public class VehicleInventoryManagement {

    private List<Vehicle> vehicles;

    public VehicleInventoryManagement(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public List<Vehicle> getVehicles(VehicleType vehicleType) {
        return this.vehicles.stream().filter(vehicle -> vehicle.getVehicleType() == vehicleType).toList();
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public void addVehicle(Vehicle vehicle) {
        this.vehicles.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        this.vehicles.remove(vehicle);
    }

    public void updateVehicle(Vehicle vehicle) {
        this.vehicles.set(this.vehicles.indexOf(vehicle), vehicle);
    }
}

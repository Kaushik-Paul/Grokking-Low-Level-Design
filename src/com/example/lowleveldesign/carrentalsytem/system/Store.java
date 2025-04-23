package com.example.lowleveldesign.carrentalsytem.system;

import com.example.lowleveldesign.carrentalsytem.product.Vehicle;
import com.example.lowleveldesign.carrentalsytem.product.VehicleType;
import com.example.lowleveldesign.carrentalsytem.user.User;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private int storeId;
    private VehicleInventoryManagement inventoryManagement;
    private StoreLocation storeLocation;
    private List<Reservation> reservations;

    public Store(StoreLocation storeLocation) {
        this.storeLocation = storeLocation;
        this.reservations = new java.util.ArrayList<>();
        this.inventoryManagement = new VehicleInventoryManagement(new ArrayList<>());
    }

    public List<Vehicle> getAllAvailableVehicles(VehicleType vehicleType) {
        return inventoryManagement.getVehicles(vehicleType);
    }

    public void setVehicles(List<Vehicle> vehicles) {
        inventoryManagement.setVehicles(vehicles);
    }

    public void addVehicle(Vehicle vehicle) {
        inventoryManagement.addVehicle(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        inventoryManagement.removeVehicle(vehicle);
    }

    public Reservation createReservation(User user, Vehicle vehicle) {
        Reservation reservation = new Reservation();
        reservation.createReservation(user, vehicle);
        this.reservations.add(reservation);
        return reservation;
    }

    public boolean completeReservation(int reservationId) {
        return true;
    }

    public Object getStoreLocation() {
        return storeLocation;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }
}

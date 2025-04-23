package com.example.lowleveldesign.carrentalsytem.system;

import com.example.lowleveldesign.carrentalsytem.product.Vehicle;
import com.example.lowleveldesign.carrentalsytem.user.User;

import java.util.List;

public class Store {
    private int storeId;
    private VehicleInventoryManagement inventoryManagement;
    private StoreLocation storeLocation;
    private List<Reservation> reservations;

    public List<Vehicle> getAllAvailableVehicles() {
        return inventoryManagement.getVehicles();
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
}

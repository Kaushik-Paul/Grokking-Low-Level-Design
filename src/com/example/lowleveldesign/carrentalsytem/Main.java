package com.example.lowleveldesign.carrentalsytem;

import com.example.lowleveldesign.carrentalsytem.payment.Bill;
import com.example.lowleveldesign.carrentalsytem.payment.Payment;
import com.example.lowleveldesign.carrentalsytem.product.Car;
import com.example.lowleveldesign.carrentalsytem.product.Vehicle;
import com.example.lowleveldesign.carrentalsytem.product.VehicleType;
import com.example.lowleveldesign.carrentalsytem.system.Reservation;
import com.example.lowleveldesign.carrentalsytem.system.Store;
import com.example.lowleveldesign.carrentalsytem.system.StoreLocation;
import com.example.lowleveldesign.carrentalsytem.system.VehicleRentalSystem;
import com.example.lowleveldesign.carrentalsytem.user.User;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<Vehicle> addVehicles(){

        List<Vehicle> vehicles = new ArrayList<>();

        Vehicle vehicle1 = new Car();
        vehicle1.setVehicleID(1);
        vehicle1.setVehicleType(VehicleType.FOUR_WHEELER);

        Vehicle vehicle2 = new Car();
        vehicle1.setVehicleID(2);
        vehicle1.setVehicleType(VehicleType.FOUR_WHEELER);

        vehicles.add(vehicle1);
        vehicles.add(vehicle2);

        return vehicles;
    }

    public static List<User> addUsers(){

        List<User> users = new ArrayList<>();
        User user1 = new User();
        user1.setUserId(1);

        users.add(user1);
        return users;
    }

    public static List<Store> addStores(List<Vehicle> vehicles){

        List<Store> stores = new ArrayList<>();
        Store store1 = new Store(new StoreLocation("address", "city", "state", "country", 12345));
        store1.setStoreId(1);
        store1.setVehicles(vehicles);

        stores.add(store1);
        return stores;
    }


    public static void main(String[] args) {
        List<User> users = addUsers();
        List<Vehicle> vehicles = addVehicles();
        List<Store> stores = addStores(vehicles);

        VehicleRentalSystem rentalSystem = new VehicleRentalSystem(stores, users);

        //0. User comes
        User user = users.getFirst();

        //1. user search store based on location
        StoreLocation location = new StoreLocation("address", "city", "state", "country", 12345);
        Store store = rentalSystem.getStore(location);

        //2. get All vehicles you are interested in (based upon different filters)
        List<Vehicle> storeVehicles = store.getAllAvailableVehicles(VehicleType.FOUR_WHEELER);


        //3.reserving the particular vehicle
        Reservation reservation = store.createReservation(user, storeVehicles.getFirst());

        //4. generate the bill
        Bill bill = new Bill(reservation);

        //5. make payment
        Payment payment = new Payment();
        payment.payBill(bill);

        //6. trip completed, submit the vehicle and close the reservation
        store.completeReservation(reservation.getReservationId());

    }
}

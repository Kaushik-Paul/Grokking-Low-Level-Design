package com.example.lowleveldesign.carrentalsytem.system;

import com.example.lowleveldesign.carrentalsytem.user.User;

import java.util.List;

public class VehicleRentalSystem {

    private List<Store> stores;
    private List<User> users;

    public VehicleRentalSystem(List<Store> stores, List<User> users) {
        this.stores = stores;
        this.users = users;
    }

    public Store getStore(StoreLocation storeLocation) {
        return this.stores.getFirst();
    }

}

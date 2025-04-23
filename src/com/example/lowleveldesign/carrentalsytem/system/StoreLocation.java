package com.example.lowleveldesign.carrentalsytem.system;

public class StoreLocation {
    private String address;
    private String city;
    private String state;
    private String country;
    private int zipCode;

    public StoreLocation(String address, String city, String state, String country, int zipCode) {
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
    }
}

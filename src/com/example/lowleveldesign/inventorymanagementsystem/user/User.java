package com.example.lowleveldesign.inventorymanagementsystem.user;

import com.example.lowleveldesign.inventorymanagementsystem.order.Cart;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int userId;
    private String userName;
    private Address address;
    private Cart userCartDetails;
    private List<Integer> orderIds;

    public User() {
        this.userCartDetails = new Cart();
        this.orderIds = new ArrayList<>();
    }

    public Cart getUserCart() {
        return this.userCartDetails;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

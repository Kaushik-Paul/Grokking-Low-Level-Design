package com.example.lowleveldesign.parkinglot.account;

import com.example.lowleveldesign.parkinglot.user.AccountStatus;
import com.example.lowleveldesign.parkinglot.user.Person;

public abstract class Account {
    private String userName;
    private String password;
    private Person person; // Refers to an instance of the Person class
    private AccountStatus status; // Refers to the AccountStatus enum

    public abstract boolean resetPassword();

    // Personal commit
}

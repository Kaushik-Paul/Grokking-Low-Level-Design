package com.example.lowleveldesign.parkinglot.account;

import com.example.lowleveldesign.parkinglot.parkinglot.DisplayBoard;
import com.example.lowleveldesign.parkinglot.parkinglot.Entrance;
import com.example.lowleveldesign.parkinglot.parkinglot.Exit;
import com.example.lowleveldesign.parkinglot.parkingslot.ParkingSpot;

public class Admin extends Account{
    // spot here refers to an instance of the ParkingSpot class
    public boolean addParkingSpot(ParkingSpot spot) {
        return false;
    }

    // displayBoard here refers to an instance of the DisplayBoard class
    public boolean addDisplayBoard(DisplayBoard displayBoard) {
        return false;
    }

    // entrance here refers to an instance of the Entrance class
    public boolean addEntrance(Entrance entrance) {
        return false;
    }

    // exit here refers to an instance of the Exit class
    public boolean addExit(Exit exit) {
        return false;
    }

    @Override
    public boolean resetPassword() {
        return false;
    }

}

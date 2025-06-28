package com.example.lowleveldesign.atm;

import com.example.lowleveldesign.atm.process.ATMRoom;

public class Main {

    public static void main(String[] args) {
        ATMRoom atmRoom = new ATMRoom();
        atmRoom.startProcess();
    }
}

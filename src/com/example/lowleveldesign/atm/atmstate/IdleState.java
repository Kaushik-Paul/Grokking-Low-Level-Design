package com.example.lowleveldesign.atm.atmstate;

import com.example.lowleveldesign.atm.atmobject.ATM;
import com.example.lowleveldesign.atm.atmobject.Card;

public class IdleState extends ATMState {

    @Override
    public void insertCard(ATM atm, Card card) {
        System.out.println("Card is inserted");
        atm.setCurrentATMState(new HasCardState());
    }

}

package com.example.lowleveldesign.atm.atmstate;

import com.example.lowleveldesign.atm.atmobject.ATM;
import com.example.lowleveldesign.atm.atmobject.Card;

public class BalanceCheckState extends ATMState {

    BalanceCheckState() {
    }

    @Override
    public void displayBalance(ATM atm, Card card) {
        System.out.println("Your balance is: " + atm.getAtmBalance());
        exit(atm);
    }

    @Override
    public void exit(ATM atm) {
        returnCard();
        atm.setCurrentATMState(new IdleState());
        System.out.println("Exited from ATM");
    }

    @Override
    public void returnCard() {
        System.out.println("Please collect your card");
    }
}

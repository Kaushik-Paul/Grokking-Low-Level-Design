package com.example.lowleveldesign.atm.atmstate;

import com.example.lowleveldesign.atm.atmobject.ATM;
import com.example.lowleveldesign.atm.atmobject.Card;

public class HasCardState extends ATMState {

    public HasCardState() {
        System.out.println("Enter your ATM pin");
    }

    @Override
    public void authenticatePin(ATM atm, Card card, int pin) {
        boolean isPinCorrect = card.isCorrectPINEntered(pin);
        if (isPinCorrect) {
            atm.setCurrentATMState(new SelectOperationState());
        } else {
            System.out.println("Incorrect pin entered!!!");
            exit(atm);
        }
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

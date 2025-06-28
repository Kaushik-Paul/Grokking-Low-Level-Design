package com.example.lowleveldesign.atm.process;

import com.example.lowleveldesign.atm.atmobject.*;

public class ATMRoom {
    private ATM atm;
    private User user;

    public void startProcess() {
        ATMRoom atmRoom = new ATMRoom();
        atmRoom.initialize();


        atmRoom.atm.printCurrentATMStatus();
        atmRoom.atm.getCurrentATMState().insertCard(atmRoom.atm, atmRoom.user.getCard());
        atmRoom.atm.getCurrentATMState().authenticatePin(atmRoom.atm, atmRoom.user.getCard(), 112211);
        atmRoom.atm.getCurrentATMState().selectOperation(atmRoom.atm, atmRoom.user.getCard(), TransactionType.CASH_WITHDRAWAL);
        atmRoom.atm.getCurrentATMState().cashWithdrawal(atmRoom.atm, atmRoom.user.getCard(), 2700);
        atmRoom.atm.printCurrentATMStatus();

    }

    private void initialize() {

        //create ATM
        atm = ATM.getATMObject();
        atm.setAtmBalance(3500, 1,2,5);

        //create User
        this.user = createUser();
    }

    private User createUser(){

        User user = new User();
        user.setCard(createCard());
        return user;
    }

    private Card createCard(){

        Card card = new Card();
        card.setBankAccount(createBankAccount());
        return card;
    }

    private UserBankAccount createBankAccount() {

        UserBankAccount bankAccount = new UserBankAccount();
        bankAccount.setBalance(3000);

        return bankAccount;
    }

}

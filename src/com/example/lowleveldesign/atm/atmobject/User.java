package com.example.lowleveldesign.atm.atmobject;

public class User {

    private Card card;
    private UserBankAccount userBankAccount;

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public UserBankAccount getUserBankAccount() {
        return userBankAccount;
    }
}

package com.example.lowleveldesign.vendingmachine.vendingmachinestate.stateimpl;

import com.example.lowleveldesign.vendingmachine.payment.Coin;
import com.example.lowleveldesign.vendingmachine.products.Item;
import com.example.lowleveldesign.vendingmachine.products.VendingMachine;
import com.example.lowleveldesign.vendingmachine.vendingmachinestate.State;

import java.util.List;

public class IdleState implements State {

    public IdleState() {
        System.out.println("Currently vending machine is in idle state");
    }

    public IdleState(VendingMachine machine) {
        System.out.println("Currently vending machine is in idle state");
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
        System.out.println("Vending machine is now will accept coins");
        machine.setVendingMachineState(new HasMoneyState());
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {
        throw new Exception("First you need to insert coins");
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
        throw new Exception("First you need to click on insert coin button");
    }

    @Override
    public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("You cannot choose a product in idle state");
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        throw new Exception("You cannot choose get change in idle state");
    }

    @Override
    public Item dispenseProduct(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("Product cannot be dispensed in idle state");
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine machine) throws Exception {
        throw new Exception("Money cannot be refunded in idle state");
    }
}

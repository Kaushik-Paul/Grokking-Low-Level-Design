package com.example.lowleveldesign.vendingmachine.vendingmachinestate.stateimpl;

import com.example.lowleveldesign.vendingmachine.payment.Coin;
import com.example.lowleveldesign.vendingmachine.products.Item;
import com.example.lowleveldesign.vendingmachine.products.VendingMachine;
import com.example.lowleveldesign.vendingmachine.vendingmachinestate.State;

import java.util.List;

public class HasMoneyState implements State {

    public HasMoneyState() {
        System.out.println("Currently vending machine is in has money state and ready to accept coins");
    }

    public HasMoneyState(VendingMachine vendingMachine) {
        System.out.println("Currently vending machine is in has money state and ready to accept coins");
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
        return;
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {
        machine.setVendingMachineState(new SelectionState());
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
        System.out.println("Accepted coin");
        machine.getCoinList().add(coin);
    }

    @Override
    public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("First you need to click on start product selection button");
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        throw new Exception("You cannot choose get change in has money state");
    }

    @Override
    public Item dispenseProduct(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("Product cannot be dispensed in has money state");
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine machine) throws Exception {
        System.out.println("Refunding the full money back in the coin dispense tray");
        machine.setVendingMachineState(new IdleState());
        return machine.getCoinList();
    }
}

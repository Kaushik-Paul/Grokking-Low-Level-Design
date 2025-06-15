package com.example.lowleveldesign.vendingmachine.vendingmachinestate.stateimpl;

import com.example.lowleveldesign.vendingmachine.payment.Coin;
import com.example.lowleveldesign.vendingmachine.products.Item;
import com.example.lowleveldesign.vendingmachine.products.VendingMachine;
import com.example.lowleveldesign.vendingmachine.vendingmachinestate.State;

import java.util.List;

public class DispenseState implements State {
    public DispenseState(VendingMachine machine, int codeNumber) throws Exception {
        System.out.println("Currently vending machine is in dispense state");
        dispenseProduct(machine, codeNumber);
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
        throw new Exception("You cannot click on insert coin button in dispense state");
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {
        throw new Exception("You cannot click on start product selection button in dispense state");
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
        throw new Exception("You cannot insert coin in dispense state");
    }

    @Override
    public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("You cannot choose a product in dispense state");
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        throw new Exception("You cannot choose get change in dispense state");
    }

    @Override
    public Item dispenseProduct(VendingMachine machine, int codeNumber) throws Exception {
        System.out.println("Product has been dispensed");
        Item item = machine.getInventory().getItem(codeNumber);
        machine.getInventory().updateSoldOutItem(codeNumber);
        machine.setVendingMachineState(new IdleState(machine));
        return item;
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine machine) throws Exception {
        throw new Exception("Money cannot be refunded in dispense state");
    }
}

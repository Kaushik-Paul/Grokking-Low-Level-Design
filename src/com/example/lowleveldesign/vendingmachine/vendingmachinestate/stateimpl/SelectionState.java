package com.example.lowleveldesign.vendingmachine.vendingmachinestate.stateimpl;

import com.example.lowleveldesign.vendingmachine.payment.Coin;
import com.example.lowleveldesign.vendingmachine.products.Item;
import com.example.lowleveldesign.vendingmachine.products.VendingMachine;
import com.example.lowleveldesign.vendingmachine.vendingmachinestate.State;

import java.util.List;

public class SelectionState implements State {
    public SelectionState() {
        System.out.println("Currently vending machine is in selection state, please select a product");
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
        throw new Exception("You cannot click on insert coin button in selection state");
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {
        return;
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
        throw new Exception("You cannot insert coin in selection state");
    }

    @Override
    public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception {
        // 1. Get the item
        Item item = machine.getInventory().getItem(codeNumber);

        // 2. Total amount paid by the customer
        int totalAmountPaid = 0;
        for (Coin coin : machine.getCoinList()) {
            totalAmountPaid = totalAmountPaid + coin.value;
        }

        // 3. Compare the total amount paid by the customer and the price of the item
        if (totalAmountPaid < item.getPrice()) {
            System.out.println("Insufficient Amount, Product you selected is for price: " + item.getPrice() + " and you paid: " + totalAmountPaid);
            refundFullMoney(machine);
            machine.setVendingMachineState(new HasMoneyState(machine));
            throw new Exception("insufficient amount");
        } else {
            if(totalAmountPaid > item.getPrice()) {
                getChange(totalAmountPaid - item.getPrice());
            }
            machine.setVendingMachineState(new DispenseState(machine, codeNumber));
        }

    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        System.out.println("Returning the change in the coin dispense tray: " + returnChangeMoney);
        return returnChangeMoney;
    }

    @Override
    public Item dispenseProduct(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("Product cannot be dispensed in selection state, as no product is selected");
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine machine) throws Exception {
        System.out.println("Refunding the full money back in the coin dispense tray");
        machine.setVendingMachineState(new IdleState());
        return machine.getCoinList();
    }
}

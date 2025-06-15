package com.example.lowleveldesign.vendingmachine.products;

import com.example.lowleveldesign.vendingmachine.payment.Coin;
import com.example.lowleveldesign.vendingmachine.vendingmachinestate.State;
import com.example.lowleveldesign.vendingmachine.vendingmachinestate.stateimpl.IdleState;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private State vendingMachineState;
    private Inventory inventory;
    private List<Coin> coinList;

    public VendingMachine() {
        this.vendingMachineState = new IdleState();
        this.inventory = new Inventory(5);
        this.coinList = new ArrayList<>();
    }

    public VendingMachine(State vendingMachineState, Inventory inventory, List<Coin> coinList) {
        this.vendingMachineState = vendingMachineState;
        this.inventory = inventory;
        this.coinList = coinList;
    }

    public State getVendingMachineState() {
        return vendingMachineState;
    }

    public void setVendingMachineState(State vendingMachineState) {
        this.vendingMachineState = vendingMachineState;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public List<Coin> getCoinList() {
        return coinList;
    }

    public void setCoinList(List<Coin> coinList) {
        this.coinList = coinList;
    }
}

package com.example.lowleveldesign.adapterdesignpattern.adapter;

import com.example.lowleveldesign.adapterdesignpattern.adaptee.WeightMachine;

public class WeightMachineAdapterImpl implements WeightMachineAdapter {
    WeightMachine weightMachine;

    public WeightMachineAdapterImpl(WeightMachine weightMachine) {
        this.weightMachine = weightMachine;
    }

    @Override
    public double getWeightInKg() {
        double weightInPounds = weightMachine.getWeightInPounds();

        // Convert pounds to kilograms
        return weightInPounds * 0.45359237;
    }
}

package com.example.lowleveldesign.adapterdesignpattern.client;

import com.example.lowleveldesign.adapterdesignpattern.adaptee.WeightMachineForBabies;
import com.example.lowleveldesign.adapterdesignpattern.adapter.WeightMachineAdapter;
import com.example.lowleveldesign.adapterdesignpattern.adapter.WeightMachineAdapterImpl;

public class Main {

    public static void main(String[] args) {

        WeightMachineAdapter weightMachineAdapter = new WeightMachineAdapterImpl(new WeightMachineForBabies());
        double weightInKg = weightMachineAdapter.getWeightInKg();
        System.out.println("Weight in kilograms: " + weightInKg);
    }
}

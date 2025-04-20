package com.example.lowleveldesign.elevatorsystem.elevator;

import com.example.lowleveldesign.elevatorsystem.elevator.system.InternalDispatcher;

public class InternalButtons {

    private InternalDispatcher internalDispatcher;
    private int[] availableButtons;
    private int buttonSelected;

    public void pressButton(int destination, ElevatorCar elevatorCar) {
        //1.check if destination is in the list of available floors

        //2.submit the request to the jobDispatcher
        internalDispatcher.submitInternalRequest(destination, elevatorCar);

    }
}

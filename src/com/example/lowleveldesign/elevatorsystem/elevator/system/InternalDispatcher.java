package com.example.lowleveldesign.elevatorsystem.elevator.system;

import com.example.lowleveldesign.elevatorsystem.elevator.ElevatorCar;
import com.example.lowleveldesign.elevatorsystem.elevator.ElevatorCreator;

import java.util.List;

public class InternalDispatcher {

    private List<ElevatorController> elevatorControllerList;

    public InternalDispatcher() {
        elevatorControllerList = ElevatorCreator.elevatorControllerList;
    }

    public void submitInternalRequest(int floor, ElevatorCar elevatorCar){

    }

}

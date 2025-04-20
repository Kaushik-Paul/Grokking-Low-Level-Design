package com.example.lowleveldesign.elevatorsystem.elevator;

import com.example.lowleveldesign.elevatorsystem.elevator.system.ElevatorController;

import java.util.ArrayList;
import java.util.List;

public class ElevatorCreator {

    public static List<ElevatorController> elevatorControllerList = new ArrayList<>();
    static {

        ElevatorCar elevatorCar1 = new ElevatorCar();
        elevatorCar1.setId(1);
        ElevatorController controller1 = new ElevatorController(elevatorCar1);

        ElevatorCar elevatorCar2 = new ElevatorCar();
        elevatorCar1.setId(2);
        ElevatorController controller2 = new ElevatorController(elevatorCar2);

        elevatorControllerList.add(controller1);
        elevatorControllerList.add(controller2);
    }

}

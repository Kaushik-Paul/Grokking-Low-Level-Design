package com.example.lowleveldesign.elevatorsystem.elevator.system;

import com.example.lowleveldesign.elevatorsystem.elevator.Direction;
import com.example.lowleveldesign.elevatorsystem.elevator.ElevatorCreator;

import java.util.List;

public class ExternalDispatcher {

    private List<ElevatorController> elevatorControllerList = ElevatorCreator.elevatorControllerList;

    public void submitExternalRequest(int floor, Direction direction) {

        //for simplicity, following even odd.
        for(ElevatorController elevatorController : elevatorControllerList) {

            int elevatorID = elevatorController.getElevatorCarId();
            if (elevatorID%2==1 && floor%2==1){
                elevatorController.submitExternalRequest(floor,direction);
            } else if(elevatorID%2==0 && floor%2==0){
                elevatorController.submitExternalRequest(floor,direction);

            }
        }

    }
}

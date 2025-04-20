package com.example.lowleveldesign.elevatorsystem.elevator.system;

import com.example.lowleveldesign.elevatorsystem.elevator.Direction;
import com.example.lowleveldesign.elevatorsystem.elevator.ElevatorCar;

import java.util.PriorityQueue;

public class ElevatorController {

    private PriorityQueue<Integer> upMinPQ;
    private PriorityQueue<Integer> downMaxPQ;
    private ElevatorCar elevatorCar;

    public ElevatorController(ElevatorCar elevatorCar) {
        this.elevatorCar = elevatorCar;
        this.upMinPQ = new PriorityQueue<>();
        this.downMaxPQ = new PriorityQueue<>();
    }

    public void submitExternalRequest(int floor, Direction direction) {
        if (direction == Direction.DOWN) {
            downMaxPQ.offer(floor);
        } else {
            upMinPQ.offer(floor);
        }
    }

    public void submitInternalRequest(int floor) {

    }

    public void controlElevator() {
        while (true) {
            if (this.elevatorCar.getElevatorDirection() == Direction.UP) {

            }
        }
    }

    public int getElevatorCarId() {
        return this.elevatorCar.getId();
    }

}

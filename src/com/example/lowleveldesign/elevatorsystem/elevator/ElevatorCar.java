package com.example.lowleveldesign.elevatorsystem.elevator;

public class ElevatorCar {
    private int id;
    private int currentFloor;
    private ElevatorDisplay elevatorDisplay;
    private InternalButtons internalButtons;
    private ElevatorState elevatorState;
    private Direction elevatorDirection;
    private ElevatorDoor elevatorDoor;

    public ElevatorCar() {
        this.currentFloor = 0;
        this.elevatorDisplay = new ElevatorDisplay();
        this.internalButtons = new InternalButtons();
        this.elevatorState = ElevatorState.IDLE;
        this.elevatorDirection = Direction.UP;
        this.elevatorDoor = new ElevatorDoor();
    }

    public void showDisplay() {
        this.elevatorDisplay.showDisplay();
    }

    public void setDisplay() {
        this.elevatorDisplay.setDisplay(currentFloor, elevatorDirection);
    }

    public void pressButton(int destination) {
        this.internalButtons.pressButton(destination, this);
    }

    public boolean moveElevator(Direction direction, int destinationFloor) {
        int startFloor = currentFloor;
        if(elevatorDirection == Direction.UP) {
            for(int i = startFloor; i<=destinationFloor; i++) {

                this.currentFloor = startFloor;
                setDisplay();
                showDisplay();
                if(i == destinationFloor) {
                    return true;
                }
            }
        }

        if(elevatorDirection == Direction.DOWN) {
            for(int i = startFloor; i>=destinationFloor; i--) {

                this.currentFloor = startFloor;
                setDisplay();
                showDisplay();
                if(i == destinationFloor) {
                    return true;
                }
            }
        }
        return false;

    }

    public Direction getElevatorDirection() {
        return elevatorDirection;
    }

    public void setElevatorDirection(Direction elevatorDirection) {
        this.elevatorDirection = elevatorDirection;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

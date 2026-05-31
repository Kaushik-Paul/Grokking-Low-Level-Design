package com.example.lowleveldesign.trafficsignalsystem.domain;

import com.example.lowleveldesign.trafficsignalsystem.domain.state.RedState;
import com.example.lowleveldesign.trafficsignalsystem.domain.state.TrafficLightState;

public class TrafficLight {
    private final Direction direction;
    private TrafficLightState currentState;

    public TrafficLight(Direction direction) {
        this.direction = direction;
        this.currentState = new RedState();
        System.out.println("Traffic light created for " + direction + " with initial RED state");
    }

    public Direction getDirection() {
        return direction;
    }

    public String getCurrentStateName() {
        return currentState.getStateName();
    }

    public TrafficLightState getCurrentState() {
        return currentState;
    }

    public void setState(TrafficLightState state) {
        this.currentState = state;
    }

    public void turnGreen() {
        currentState.turnGreen(this);
    }

    public void turnYellow() {
        currentState.turnYellow(this);
    }

    public void turnRed() {
        currentState.turnRed(this);
    }

    public void turnOff() {
        currentState.turnOff(this);
    }

    @Override
    public String toString() {
        return "TrafficLight{direction=" + direction + ", state='" + getCurrentStateName() + "'}";
    }
}

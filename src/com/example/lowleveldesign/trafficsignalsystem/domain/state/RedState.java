package com.example.lowleveldesign.trafficsignalsystem.domain.state;

import com.example.lowleveldesign.trafficsignalsystem.domain.TrafficLight;

public class RedState implements TrafficLightState {
    @Override
    public void turnGreen(TrafficLight trafficLight) {
        trafficLight.setState(new GreenState());
        System.out.println("Traffic light " + trafficLight.getDirection() + " changed from RED to GREEN");
    }

    @Override
    public void turnYellow(TrafficLight trafficLight) {
        throw new InvalidStateTransitionException("RED", "YELLOW");
    }

    @Override
    public void turnRed(TrafficLight trafficLight) {
        System.out.println("Traffic light " + trafficLight.getDirection() + " is already RED");
    }

    @Override
    public void turnOff(TrafficLight trafficLight) {
        trafficLight.setState(new OffState());
        System.out.println("Traffic light " + trafficLight.getDirection() + " changed from RED to OFF");
    }

    @Override
    public String getStateName() {
        return "RED";
    }

    @Override
    public boolean canTransitionTo(TrafficLightState newState) {
        return newState instanceof GreenState || newState instanceof OffState;
    }
}

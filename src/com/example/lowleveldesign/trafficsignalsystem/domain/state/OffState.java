package com.example.lowleveldesign.trafficsignalsystem.domain.state;

import com.example.lowleveldesign.trafficsignalsystem.domain.TrafficLight;

public class OffState implements TrafficLightState {
    @Override
    public void turnGreen(TrafficLight trafficLight) {
        trafficLight.setState(new GreenState());
        System.out.println("Traffic light " + trafficLight.getDirection() + " changed from OFF to GREEN");
    }

    @Override
    public void turnYellow(TrafficLight trafficLight) {
        trafficLight.setState(new YellowState());
        System.out.println("Traffic light " + trafficLight.getDirection() + " changed from OFF to YELLOW");
    }

    @Override
    public void turnRed(TrafficLight trafficLight) {
        trafficLight.setState(new RedState());
        System.out.println("Traffic light " + trafficLight.getDirection() + " changed from OFF to RED");
    }

    @Override
    public void turnOff(TrafficLight trafficLight) {
        System.out.println("Traffic light " + trafficLight.getDirection() + " is already OFF");
    }

    @Override
    public String getStateName() {
        return "OFF";
    }

    @Override
    public boolean canTransitionTo(TrafficLightState newState) {
        return true;
    }
}

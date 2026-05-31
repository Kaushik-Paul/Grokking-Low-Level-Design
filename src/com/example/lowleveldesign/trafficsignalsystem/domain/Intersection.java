package com.example.lowleveldesign.trafficsignalsystem.domain;

import java.util.EnumMap;
import java.util.Map;

public class Intersection {
    private final int id;
    private final String name;
    private final Map<Direction, TrafficLight> trafficLights = new EnumMap<>(Direction.class);
    private boolean emergencyMode;
    private Direction emergencyDirection;
    private boolean cyclePaused;

    public Intersection(int id, String name) {
        this.id = id;
        this.name = name;
        for (Direction direction : Direction.getAllDirections()) {
            trafficLights.put(direction, new TrafficLight(direction));
        }
        System.out.println("Intersection created: " + name + " (ID: " + id + ")");
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isEmergencyMode() {
        return emergencyMode;
    }

    public Direction getEmergencyDirection() {
        return emergencyDirection;
    }

    public boolean isCyclePaused() {
        return cyclePaused;
    }

    public void setEmergencyMode(boolean emergencyMode) {
        this.emergencyMode = emergencyMode;
        System.out.println("Emergency mode " + (emergencyMode ? "enabled" : "disabled") + " for intersection " + id);
    }

    public void setEmergencyDirection(Direction emergencyDirection) {
        this.emergencyDirection = emergencyDirection;
        System.out.println("Emergency direction set to " + emergencyDirection + " for intersection " + id);
    }

    public void setCyclePaused(boolean cyclePaused) {
        this.cyclePaused = cyclePaused;
        System.out.println("Cycle " + (cyclePaused ? "paused" : "resumed") + " for intersection " + id);
    }

    public TrafficLight getTrafficLight(Direction direction) {
        return trafficLights.get(direction);
    }

    public void setAllSignalsToRed() {
        for (TrafficLight light : trafficLights.values()) {
            emergencyTransitionToRed(light.getDirection());
        }
        System.out.println("All signals set to RED for intersection " + id);
    }

    public void setSignalToGreen(Direction direction) {
        getTrafficLight(direction).turnGreen();
        System.out.println("Signal " + direction + " set to GREEN for intersection " + id);
    }

    public void setSignalToYellow(Direction direction) {
        getTrafficLight(direction).turnYellow();
        System.out.println("Signal " + direction + " set to YELLOW for intersection " + id);
    }

    public void setSignalToRed(Direction direction) {
        getTrafficLight(direction).turnRed();
        System.out.println("Signal " + direction + " set to RED for intersection " + id);
    }

    public void setSignalToOff(Direction direction) {
        getTrafficLight(direction).turnOff();
        System.out.println("Signal " + direction + " set to OFF for intersection " + id);
    }

    public void emergencyTransitionToRed(Direction direction) {
        TrafficLight light = getTrafficLight(direction);
        String state = light.getCurrentStateName();
        if ("GREEN".equals(state)) {
            System.out.println("Emergency transition: " + direction + " GREEN -> YELLOW -> RED");
            light.turnYellow();
            light.turnRed();
        } else if ("YELLOW".equals(state)) {
            System.out.println("Emergency transition: " + direction + " YELLOW -> RED");
            light.turnRed();
        } else if ("RED".equals(state)) {
            System.out.println("Emergency transition: " + direction + " already RED");
        } else {
            System.out.println("Emergency transition: " + direction + " -> RED");
            light.turnRed();
        }
    }

    @Override
    public String toString() {
        return "Intersection{id=" + id + ", name='" + name + "', emergencyMode=" + emergencyMode +
                ", emergencyDirection=" + emergencyDirection + ", cyclePaused=" + cyclePaused + "}";
    }
}

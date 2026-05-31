package com.example.lowleveldesign.trafficsignalsystem.controller;

import com.example.lowleveldesign.trafficsignalsystem.domain.Direction;
import com.example.lowleveldesign.trafficsignalsystem.service.TrafficService;

public class TrafficController {
    private final TrafficService trafficService;

    public TrafficController(TrafficService trafficService) {
        this.trafficService = trafficService;
        System.out.println("TrafficController initialized");
    }

    public void updateVehicleCount(Direction direction, int count) {
        trafficService.updateVehicleCount(direction, count);
    }

    public void getVehicleCount(Direction direction) {
        int count = trafficService.getVehicleCount(direction);
        System.out.println("Traffic count for " + direction + ": " + count);
    }

    public void displayTrafficStatus() {
        System.out.println("\n--- Traffic Status ---");
        for (Direction direction : Direction.getAllDirections()) {
            System.out.println("  " + direction + ": " + trafficService.getVehicleCount(direction) + " vehicles");
        }
        System.out.println("----------------------");
    }
}

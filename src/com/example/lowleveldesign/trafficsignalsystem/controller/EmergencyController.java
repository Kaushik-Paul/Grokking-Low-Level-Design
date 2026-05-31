package com.example.lowleveldesign.trafficsignalsystem.controller;

import com.example.lowleveldesign.trafficsignalsystem.domain.Direction;
import com.example.lowleveldesign.trafficsignalsystem.domain.EmergencyRequest;
import com.example.lowleveldesign.trafficsignalsystem.service.EmergencyService;

public class EmergencyController {
    private final EmergencyService emergencyService;

    public EmergencyController(EmergencyService emergencyService) {
        this.emergencyService = emergencyService;
        System.out.println("EmergencyController initialized");
    }

    public void requestEmergency(int intersectionId, Direction direction, int durationSeconds) {
        emergencyService.requestEmergency(intersectionId, direction, durationSeconds);
    }

    public void endEmergency(int intersectionId) {
        emergencyService.endEmergency(intersectionId);
    }

    public void getEmergencyStatus(int intersectionId) {
        EmergencyRequest request = emergencyService.getActiveEmergency(intersectionId);
        if (request != null) {
            System.out.println("\n--- Emergency Status: " + intersectionId + " ---");
            System.out.println(request);
            System.out.println("------------------------------------------");
        } else {
            System.out.println("No active emergency for intersection " + intersectionId);
        }
    }
}

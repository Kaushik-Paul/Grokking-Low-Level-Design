package com.example.lowleveldesign.trafficsignalsystem.service;

import com.example.lowleveldesign.trafficsignalsystem.domain.Direction;
import com.example.lowleveldesign.trafficsignalsystem.domain.EmergencyRequest;
import com.example.lowleveldesign.trafficsignalsystem.domain.Intersection;
import com.example.lowleveldesign.trafficsignalsystem.repository.EmergencyRepository;

public class EmergencyService {
    private final EmergencyRepository emergencyRepository;
    private final IntersectionService intersectionService;

    public EmergencyService(EmergencyRepository emergencyRepository, IntersectionService intersectionService) {
        this.emergencyRepository = emergencyRepository;
        this.intersectionService = intersectionService;
    }

    public void requestEmergency(int intersectionId, Direction direction, int durationSeconds) {
        Intersection intersection = intersectionService.getIntersection(intersectionId);
        if (intersection == null) {
            throw new IllegalArgumentException("Intersection not found: " + intersectionId);
        }
        EmergencyRequest request = new EmergencyRequest(
                emergencyRepository.nextId(), intersectionId, direction, durationSeconds);
        emergencyRepository.save(request);

        intersection.setEmergencyMode(true);
        intersection.setEmergencyDirection(direction);
        intersectionService.pauseCycle(intersectionId);
        intersectionService.emergencySetAllSignalsToRed(intersectionId);
        intersectionService.setSignalToGreen(intersectionId, direction);
        System.out.println("Emergency priority granted for " + direction + " at intersection " + intersectionId);
    }

    public void endEmergency(int intersectionId) {
        EmergencyRequest request = emergencyRepository.findActiveByIntersectionId(intersectionId);
        if (request == null) {
            System.out.println("No active emergency for intersection " + intersectionId);
            return;
        }
        request.setActive(false);
        Intersection intersection = intersectionService.getIntersection(intersectionId);
        intersectionService.emergencySetAllSignalsToRed(intersectionId);
        intersection.setEmergencyMode(false);
        intersectionService.resumeCycle(intersectionId);
        emergencyRepository.removeActiveByIntersectionId(intersectionId);
        System.out.println("Emergency ended for intersection " + intersectionId);
    }

    public EmergencyRequest getActiveEmergency(int intersectionId) {
        return emergencyRepository.findActiveByIntersectionId(intersectionId);
    }
}

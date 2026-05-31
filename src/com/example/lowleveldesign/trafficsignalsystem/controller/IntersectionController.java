package com.example.lowleveldesign.trafficsignalsystem.controller;

import com.example.lowleveldesign.trafficsignalsystem.domain.Direction;
import com.example.lowleveldesign.trafficsignalsystem.domain.Intersection;
import com.example.lowleveldesign.trafficsignalsystem.domain.IntersectionCycle;
import com.example.lowleveldesign.trafficsignalsystem.domain.TrafficLight;
import com.example.lowleveldesign.trafficsignalsystem.service.IntersectionService;

public class IntersectionController {
    private final IntersectionService intersectionService;

    public IntersectionController(IntersectionService intersectionService) {
        this.intersectionService = intersectionService;
        System.out.println("IntersectionController initialized");
    }

    public void createIntersection(int id, String name) {
        intersectionService.createIntersection(id, name);
    }

    public Intersection getIntersection(int intersectionId) {
        return intersectionService.getIntersection(intersectionId);
    }

    public void startCycle(int intersectionId) {
        intersectionService.startAutomaticCycle(intersectionId);
    }

    public void advanceCycleOnce(int intersectionId) {
        intersectionService.advanceCycleOnce(intersectionId);
    }

    public void displayStatus(int intersectionId) {
        Intersection intersection = intersectionService.getIntersection(intersectionId);
        if (intersection == null) {
            System.out.println("Intersection not found: " + intersectionId);
            return;
        }
        System.out.println("\n--- Intersection Status: " + intersection.getName() + " ---");
        System.out.println(intersection);
        for (Direction direction : Direction.getAllDirections()) {
            TrafficLight light = intersection.getTrafficLight(direction);
            System.out.println("  " + light);
        }
        IntersectionCycle cycle = intersectionService.getCycle(intersectionId);
        if (cycle != null) {
            System.out.println("  " + cycle);
        }
        System.out.println("------------------------------------------");
    }
}

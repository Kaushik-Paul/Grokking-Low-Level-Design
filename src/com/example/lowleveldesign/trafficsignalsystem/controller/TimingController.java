package com.example.lowleveldesign.trafficsignalsystem.controller;

import com.example.lowleveldesign.trafficsignalsystem.domain.Direction;
import com.example.lowleveldesign.trafficsignalsystem.domain.SignalTiming;
import com.example.lowleveldesign.trafficsignalsystem.service.TimingService;

public class TimingController {
    private final TimingService timingService;

    public TimingController(TimingService timingService) {
        this.timingService = timingService;
        System.out.println("TimingController initialized");
    }

    public void setSignalTiming(int intersectionId, Direction direction, int greenDurationSeconds) {
        timingService.setSignalTiming(intersectionId, direction, greenDurationSeconds);
    }

    public void enableDynamicTiming(int intersectionId, Direction direction, boolean enable) {
        timingService.enableDynamicTiming(intersectionId, direction, enable);
    }

    public void getSignalTiming(int intersectionId, Direction direction) {
        SignalTiming timing = timingService.getSignalTiming(intersectionId, direction);
        if (timing != null) {
            System.out.println("Signal timing for " + direction + ": " + timing);
        }
    }

    public void adjustTimingBasedOnTraffic(int intersectionId, Direction direction) {
        timingService.adjustTimingBasedOnTraffic(intersectionId, direction);
    }

    public void displayTimingStatus(int intersectionId) {
        System.out.println("\n--- Timing Status: " + intersectionId + " ---");
        for (Direction direction : Direction.getAllDirections()) {
            SignalTiming timing = timingService.getSignalTiming(intersectionId, direction);
            if (timing != null) {
                System.out.println("  " + timing);
            }
        }
        System.out.println("------------------------------------------");
    }
}

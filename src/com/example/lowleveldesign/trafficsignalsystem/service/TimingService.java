package com.example.lowleveldesign.trafficsignalsystem.service;

import com.example.lowleveldesign.trafficsignalsystem.domain.Direction;
import com.example.lowleveldesign.trafficsignalsystem.domain.SignalTiming;
import com.example.lowleveldesign.trafficsignalsystem.repository.TimingRepository;

public class TimingService {
    private static final int DEFAULT_GREEN_SECONDS = 30;
    private static final int MIN_GREEN_SECONDS = 15;
    private static final int MAX_GREEN_SECONDS = 90;

    private final TimingRepository timingRepository;
    private final TrafficService trafficService;

    public TimingService(TimingRepository timingRepository, TrafficService trafficService) {
        this.timingRepository = timingRepository;
        this.trafficService = trafficService;
    }

    public void initializeDefaultTimings(int intersectionId) {
        for (Direction direction : Direction.getAllDirections()) {
            timingRepository.save(new SignalTiming(intersectionId, direction, DEFAULT_GREEN_SECONDS));
        }
    }

    public void setSignalTiming(int intersectionId, Direction direction, int greenDurationSeconds) {
        SignalTiming timing = getSignalTiming(intersectionId, direction);
        if (timing == null) {
            timing = new SignalTiming(intersectionId, direction, greenDurationSeconds);
        } else {
            timing.setGreenDurationSeconds(greenDurationSeconds);
        }
        timingRepository.save(timing);
    }

    public void enableDynamicTiming(int intersectionId, Direction direction, boolean enable) {
        SignalTiming timing = getSignalTiming(intersectionId, direction);
        if (timing == null) {
            timing = new SignalTiming(intersectionId, direction, DEFAULT_GREEN_SECONDS);
        }
        timing.setDynamic(enable);
        timingRepository.save(timing);
    }

    public SignalTiming getSignalTiming(int intersectionId, Direction direction) {
        return timingRepository.findByIntersectionAndDirection(intersectionId, direction);
    }

    public void adjustTimingBasedOnTraffic(int intersectionId, Direction direction) {
        int vehicleCount = trafficService.getVehicleCount(direction);
        int optimalDuration = calculateOptimalGreenDuration(vehicleCount);
        setSignalTiming(intersectionId, direction, optimalDuration);
        System.out.println("Adjusted timing for " + direction + " based on " + vehicleCount + " vehicles");
    }

    public int calculateOptimalGreenDuration(int vehicleCount) {
        int calculated = MIN_GREEN_SECONDS + vehicleCount;
        return Math.max(MIN_GREEN_SECONDS, Math.min(MAX_GREEN_SECONDS, calculated));
    }
}

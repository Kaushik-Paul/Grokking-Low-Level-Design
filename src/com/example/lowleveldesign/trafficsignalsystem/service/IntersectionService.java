package com.example.lowleveldesign.trafficsignalsystem.service;

import com.example.lowleveldesign.trafficsignalsystem.domain.Direction;
import com.example.lowleveldesign.trafficsignalsystem.domain.Intersection;
import com.example.lowleveldesign.trafficsignalsystem.domain.IntersectionCycle;
import com.example.lowleveldesign.trafficsignalsystem.domain.SignalTiming;
import com.example.lowleveldesign.trafficsignalsystem.repository.CycleRepository;
import com.example.lowleveldesign.trafficsignalsystem.repository.IntersectionRepository;

public class IntersectionService {
    private final IntersectionRepository intersectionRepository;
    private final CycleRepository cycleRepository;
    private final TimingService timingService;

    public IntersectionService(IntersectionRepository intersectionRepository,
                               CycleRepository cycleRepository,
                               TimingService timingService) {
        this.intersectionRepository = intersectionRepository;
        this.cycleRepository = cycleRepository;
        this.timingService = timingService;
    }

    public void createIntersection(int id, String name) {
        Intersection intersection = new Intersection(id, name);
        intersectionRepository.save(intersection);
        cycleRepository.save(new IntersectionCycle(id));
        timingService.initializeDefaultTimings(id);
    }

    public Intersection getIntersection(int intersectionId) {
        return intersectionRepository.findById(intersectionId);
    }

    public IntersectionCycle getCycle(int intersectionId) {
        return cycleRepository.findByIntersectionId(intersectionId);
    }

    public void startAutomaticCycle(int intersectionId) {
        Intersection intersection = requireIntersection(intersectionId);
        IntersectionCycle cycle = getCycle(intersectionId);
        Direction currentDirection = cycle.getCurrentDirection();
        intersection.setAllSignalsToRed();
        intersection.setSignalToGreen(currentDirection);
        SignalTiming timing = timingService.getSignalTiming(intersectionId, currentDirection);
        System.out.println("Automatic cycle started at " + currentDirection + " for " +
                timing.getGreenDurationSeconds() + "s green duration");
    }

    public void advanceCycleOnce(int intersectionId) {
        Intersection intersection = requireIntersection(intersectionId);
        IntersectionCycle cycle = getCycle(intersectionId);
        if (cycle.isPaused()) {
            System.out.println("Cycle is paused; cannot advance");
            return;
        }
        Direction currentDirection = cycle.getCurrentDirection();
        intersection.setSignalToYellow(currentDirection);
        intersection.setSignalToRed(currentDirection);
        cycle.nextPhase();
        Direction nextDirection = cycle.getCurrentDirection();
        intersection.setSignalToGreen(nextDirection);
        System.out.println("Cycle advanced to " + nextDirection);
    }

    public void pauseCycle(int intersectionId) {
        requireIntersection(intersectionId).setCyclePaused(true);
        getCycle(intersectionId).setPaused(true);
    }

    public void resumeCycle(int intersectionId) {
        requireIntersection(intersectionId).setCyclePaused(false);
        getCycle(intersectionId).setPaused(false);
    }

    public void setAllSignalsToRed(int intersectionId) {
        requireIntersection(intersectionId).setAllSignalsToRed();
    }

    public void emergencySetAllSignalsToRed(int intersectionId) {
        Intersection intersection = requireIntersection(intersectionId);
        for (Direction direction : Direction.getAllDirections()) {
            intersection.emergencyTransitionToRed(direction);
        }
    }

    public void setSignalToGreen(int intersectionId, Direction direction) {
        requireIntersection(intersectionId).setSignalToGreen(direction);
    }

    private Intersection requireIntersection(int intersectionId) {
        Intersection intersection = getIntersection(intersectionId);
        if (intersection == null) {
            throw new IllegalArgumentException("Intersection not found: " + intersectionId);
        }
        return intersection;
    }
}

package com.example.lowleveldesign.trafficsignalsystem.domain;

import java.time.Duration;
import java.time.Instant;

public class IntersectionCycle {
    private final int intersectionId;
    private int currentPhase;
    private boolean paused;
    private int pausedAtPhase;
    private Instant phaseStartTime;
    private Instant pauseStartTime;
    private Duration totalPauseTime = Duration.ZERO;

    public IntersectionCycle(int intersectionId) {
        this.intersectionId = intersectionId;
        this.currentPhase = 0;
        this.phaseStartTime = Instant.now();
        System.out.println("Intersection cycle created for intersection: " + intersectionId);
    }

    public int getIntersectionId() {
        return intersectionId;
    }

    public int getCurrentPhase() {
        return currentPhase;
    }

    public boolean isPaused() {
        return paused;
    }

    public int getPausedAtPhase() {
        return pausedAtPhase;
    }

    public long getPhaseElapsedMillis() {
        Instant end = paused ? pauseStartTime : Instant.now();
        Duration rawElapsed = Duration.between(phaseStartTime, end);
        return Math.max(0, rawElapsed.minus(totalPauseTime).toMillis());
    }

    public long getPhaseRemainingMillis(int phaseDurationSeconds) {
        return Math.max(0, phaseDurationSeconds * 1000L - getPhaseElapsedMillis());
    }

    public void setCurrentPhase(int currentPhase) {
        this.currentPhase = currentPhase;
        this.phaseStartTime = Instant.now();
        this.totalPauseTime = Duration.ZERO;
        System.out.println("Phase changed to " + currentPhase + " for intersection " + intersectionId);
    }

    public void setPaused(boolean paused) {
        if (this.paused == paused) {
            return;
        }
        this.paused = paused;
        if (paused) {
            this.pausedAtPhase = currentPhase;
            this.pauseStartTime = Instant.now();
            System.out.println("Cycle paused at phase " + currentPhase + " for intersection " + intersectionId);
        } else {
            this.totalPauseTime = totalPauseTime.plus(Duration.between(pauseStartTime, Instant.now()));
            System.out.println("Cycle resumed from phase " + pausedAtPhase + " for intersection " + intersectionId);
        }
    }

    public void nextPhase() {
        setCurrentPhase((currentPhase + 1) % 4);
    }

    public boolean isPhaseComplete(int phaseDurationSeconds) {
        return getPhaseElapsedMillis() >= phaseDurationSeconds * 1000L;
    }

    public Direction getCurrentDirection() {
        return Direction.getAllDirections().get(currentPhase);
    }

    @Override
    public String toString() {
        return "IntersectionCycle{intersectionId=" + intersectionId + ", currentPhase=" + currentPhase +
                ", currentDirection=" + getCurrentDirection() + ", paused=" + paused +
                ", phaseElapsedSeconds=" + getPhaseElapsedMillis() / 1000 + "}";
    }
}

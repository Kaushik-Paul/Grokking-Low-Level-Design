package com.example.lowleveldesign.trafficsignalsystem.domain;

import java.time.Duration;
import java.time.Instant;

public class EmergencyRequest {
    private final int id;
    private final int intersectionId;
    private final Direction direction;
    private int durationSeconds;
    private boolean active;
    private final Instant requestTime;

    public EmergencyRequest(int id, int intersectionId, Direction direction, int durationSeconds) {
        this.id = id;
        this.intersectionId = intersectionId;
        this.direction = direction;
        this.durationSeconds = durationSeconds;
        this.active = true;
        this.requestTime = Instant.now();
        System.out.println("Emergency request created: ID=" + id + ", Intersection=" + intersectionId +
                ", Direction=" + direction + ", Duration=" + durationSeconds + "s");
    }

    public int getId() { return id; }
    public int getIntersectionId() { return intersectionId; }
    public Direction getDirection() { return direction; }
    public int getDurationSeconds() { return durationSeconds; }
    public boolean isActive() { return active; }

    public void setActive(boolean active) {
        this.active = active;
        System.out.println("Emergency request " + id + " " + (active ? "activated" : "deactivated"));
    }

    public boolean isExpired() {
        return Duration.between(requestTime, Instant.now()).getSeconds() >= durationSeconds;
    }

    @Override
    public String toString() {
        return "EmergencyRequest{id=" + id + ", intersectionId=" + intersectionId + ", direction=" + direction +
                ", durationSeconds=" + durationSeconds + ", active=" + active + "}";
    }
}

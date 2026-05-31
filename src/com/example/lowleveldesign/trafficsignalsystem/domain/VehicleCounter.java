package com.example.lowleveldesign.trafficsignalsystem.domain;

import java.time.Instant;

public class VehicleCounter {
    private final Direction direction;
    private int count;
    private Instant lastUpdate;

    public VehicleCounter(Direction direction) {
        this.direction = direction;
        this.lastUpdate = Instant.now();
    }

    public Direction getDirection() {
        return direction;
    }

    public int getCount() {
        return count;
    }

    public Instant getLastUpdate() {
        return lastUpdate;
    }

    public void updateCount(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("Vehicle count cannot be negative");
        }
        this.count = count;
        this.lastUpdate = Instant.now();
        System.out.println("Vehicle count for " + direction + " updated to " + count);
    }

    @Override
    public String toString() {
        return "VehicleCounter{direction=" + direction + ", count=" + count + ", lastUpdate=" + lastUpdate + "}";
    }
}

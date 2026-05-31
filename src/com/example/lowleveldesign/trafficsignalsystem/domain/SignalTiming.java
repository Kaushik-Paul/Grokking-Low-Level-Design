package com.example.lowleveldesign.trafficsignalsystem.domain;

public class SignalTiming {
    public static final int YELLOW_DURATION_SECONDS = 3;

    private final int intersectionId;
    private final Direction direction;
    private int greenDurationSeconds;
    private boolean dynamic;

    public SignalTiming(int intersectionId, Direction direction, int greenDurationSeconds) {
        this.intersectionId = intersectionId;
        this.direction = direction;
        this.greenDurationSeconds = greenDurationSeconds;
    }

    public int getIntersectionId() {
        return intersectionId;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getGreenDurationSeconds() {
        return greenDurationSeconds;
    }

    public void setGreenDurationSeconds(int greenDurationSeconds) {
        this.greenDurationSeconds = greenDurationSeconds;
        System.out.println("Green duration for " + direction + " updated to " + greenDurationSeconds + "s");
    }

    public boolean isDynamic() {
        return dynamic;
    }

    public void setDynamic(boolean dynamic) {
        this.dynamic = dynamic;
        System.out.println("Dynamic timing for " + direction + " set to " + dynamic);
    }

    @Override
    public String toString() {
        return "SignalTiming{intersectionId=" + intersectionId + ", direction=" + direction +
                ", greenDurationSeconds=" + greenDurationSeconds + ", yellowDurationSeconds=" +
                YELLOW_DURATION_SECONDS + ", dynamic=" + dynamic + "}";
    }
}

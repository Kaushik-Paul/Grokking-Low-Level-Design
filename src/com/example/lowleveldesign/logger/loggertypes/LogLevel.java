package com.example.lowleveldesign.logger.loggertypes;

public enum LogLevel {
    INFO(1),
    DEBUG(2),
    ERROR(3);

    private final int value;

    LogLevel(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

package com.example.lowleveldesign.loggingframework.core;

/**
 * Represents the severity level of a log message.
 * Each level has a priority value for comparison.
 */
public enum LogLevel {
    DEBUG(1),
    INFO(2),
    WARNING(3),
    ERROR(4),
    FATAL(5);

    private final int priority;

    LogLevel(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    /**
     * Checks if this level is greater than or equal to the other level.
     * @param other The level to compare against
     * @return true if this level's priority >= other level's priority
     */
    public boolean isGreaterOrEqual(LogLevel other) {
        return this.priority >= other.priority;
    }
} 
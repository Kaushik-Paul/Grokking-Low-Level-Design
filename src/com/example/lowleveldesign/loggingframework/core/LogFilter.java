package com.example.lowleveldesign.loggingframework.core;

/**
 * Interface for filtering log messages.
 * Different implementations can filter based on level, source, time, or custom criteria.
 */
public interface LogFilter {
    
    /**
     * Determines if a log message should be processed.
     * @param message The log message to check
     * @return true if the message should be logged, false if it should be dropped
     */
    boolean shouldLog(LogMessage message);
    
    /**
     * Sets the minimum log level for this filter.
     * @param level The minimum level to allow
     */
    void setLevel(LogLevel level);
    
    /**
     * Gets the current minimum log level for this filter.
     * @return The current minimum level
     */
    LogLevel getLevel();
} 
package com.example.lowleveldesign.loggingframework.core;

/**
 * Interface for output destinations that can receive and process log messages.
 * Different implementations can write to console, file, database, etc.
 */
public interface LogAppender {
    
    /**
     * Appends a log message to this appender's destination.
     * @param message The log message to append
     */
    void append(LogMessage message);
    
    /**
     * Sets the minimum log level for this appender.
     * @param level The minimum level to log
     */
    void setLevel(LogLevel level);
    
    /**
     * Gets the current minimum log level for this appender.
     * @return The current minimum level
     */
    LogLevel getLevel();
    
    /**
     * Checks if this appender is enabled for the given log level.
     * @param level The level to check
     * @return true if the appender should process messages at this level
     */
    boolean isEnabled(LogLevel level);
    
    /**
     * Sets the formatter for this appender.
     * @param formatter The formatter to use
     */
    void setFormatter(LogFormatter formatter);
    
    /**
     * Gets the current formatter for this appender.
     * @return The current formatter
     */
    LogFormatter getFormatter();
} 
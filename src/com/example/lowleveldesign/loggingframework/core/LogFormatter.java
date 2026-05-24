package com.example.lowleveldesign.loggingframework.core;

/**
 * Interface for formatting log messages into strings.
 * Different implementations can format messages in different ways (JSON, XML, plain text, etc.).
 */
public interface LogFormatter {
    
    /**
     * Formats a log message into a string representation.
     * @param message The log message to format
     * @return The formatted string
     */
    String format(LogMessage message);
    
    /**
     * Sets the pattern for formatting.
     * @param pattern The pattern string
     */
    void setPattern(String pattern);
    
    /**
     * Gets the current pattern for formatting.
     * @return The current pattern
     */
    String getPattern();
    
    /**
     * Sets the date format for timestamps.
     * @param dateFormat The date format string
     */
    void setDateFormat(String dateFormat);
} 
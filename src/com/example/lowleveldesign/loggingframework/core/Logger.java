package com.example.lowleveldesign.loggingframework.core;

import java.util.List;

/**
 * Main interface for logging operations.
 * Provides methods for logging at different levels and managing appenders and filters.
 */
public interface Logger {
    
    // Logging methods for different levels
    void debug(String message);
    void info(String message);
    void warning(String message);
    void error(String message);
    void fatal(String message);
    
    // Generic logging method
    void log(LogLevel level, String message);
    
    // Configuration methods
    void setLevel(LogLevel level);
    void addAppender(LogAppender appender);
    void addFilter(LogFilter filter);
    void removeFilter(LogFilter filter);
    
    // Getter methods
    List<LogAppender> getAppenders();
    List<LogFilter> getFilters();
} 
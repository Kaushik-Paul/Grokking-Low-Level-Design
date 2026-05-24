package com.example.lowleveldesign.loggingframework.core;

import com.example.lowleveldesign.loggingframework.appenders.ConsoleAppender;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Main implementation of the Logger interface.
 * Provides thread-safe logging with support for multiple appenders and filters.
 */
public class LoggerImpl implements Logger {
    private final String name;
    private LogLevel level;
    private final List<LogAppender> appenders;
    private final List<LogFilter> filters;

    public LoggerImpl() {
        this("DefaultLogger");
    }

    public LoggerImpl(String name) {
        this(name, true); // Default to adding console appender
    }
    
    public LoggerImpl(String name, boolean addDefaultAppender) {
        this.name = name;
        this.level = LogLevel.DEBUG; // Default level - changed to DEBUG to show all messages
        this.appenders = Collections.synchronizedList(new ArrayList<>());
        this.filters = Collections.synchronizedList(new ArrayList<>());
        
        // Add default console appender only if requested
        if (addDefaultAppender) {
            addAppender(new ConsoleAppender());
        }
    }

    public LoggerImpl(String name, LogConfiguration config) {
        this(name);
        this.level = config.getRootLevel();
    }

    @Override
    public synchronized void debug(String message) {
        log(LogLevel.DEBUG, message);
    }

    @Override
    public synchronized void info(String message) {
        log(LogLevel.INFO, message);
    }

    @Override
    public synchronized void warning(String message) {
        log(LogLevel.WARNING, message);
    }

    @Override
    public synchronized void error(String message) {
        log(LogLevel.ERROR, message);
    }

    @Override
    public synchronized void fatal(String message) {
        log(LogLevel.FATAL, message);
    }

    @Override
    public synchronized void log(LogLevel level, String message) {
        // Check if message should be logged based on level
        if (!level.isGreaterOrEqual(this.level)) {
            return;
        }

        // Create log message
        LogMessage logMessage = new LogMessage.Builder()
            .level(level)
            .message(message)
            .source(getCallingClass())
            .build();

        // Apply filters
        for (LogFilter filter : filters) {
            if (!filter.shouldLog(logMessage)) {
                return; // Message filtered out
            }
        }

        // Send to all appenders
        for (LogAppender appender : appenders) {
            if (appender.isEnabled(level)) {
                appender.append(logMessage);
            }
        }
    }

    @Override
    public void setLevel(LogLevel level) {
        this.level = level;
    }

    @Override
    public void addAppender(LogAppender appender) {
        appenders.add(appender);
    }

    @Override
    public void addFilter(LogFilter filter) {
        filters.add(filter);
    }

    @Override
    public void removeFilter(LogFilter filter) {
        filters.remove(filter);
    }

    public String getName() {
        return name;
    }

    public LogLevel getLevel() {
        return level;
    }

    public List<LogAppender> getAppenders() {
        return new ArrayList<>(appenders);
    }

    public List<LogFilter> getFilters() {
        return new ArrayList<>(filters);
    }

    /**
     * Gets the calling class name for source information.
     * This is a simplified implementation.
     */
    private String getCallingClass() {
        try {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            if (stackTrace.length > 3) {
                String className = stackTrace[3].getClassName();
                String methodName = stackTrace[3].getMethodName();
                return className + "." + methodName;
            }
        } catch (Exception e) {
            // Ignore exceptions in source detection
        }
        return "Unknown";
    }
} 
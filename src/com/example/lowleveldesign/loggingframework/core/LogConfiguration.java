package com.example.lowleveldesign.loggingframework.core;

/**
 * Configuration settings for the logging framework.
 * Contains root level and other configuration parameters.
 */
public class LogConfiguration {
    private LogLevel rootLevel;

    public LogConfiguration() {
        this.rootLevel = LogLevel.INFO; // Default level
    }

    public LogConfiguration(LogLevel rootLevel) {
        this.rootLevel = rootLevel;
    }

    public LogLevel getRootLevel() {
        return rootLevel;
    }

    public void setRootLevel(LogLevel rootLevel) {
        this.rootLevel = rootLevel;
    }

    @Override
    public String toString() {
        return String.format("LogConfiguration{rootLevel=%s}", rootLevel);
    }
} 
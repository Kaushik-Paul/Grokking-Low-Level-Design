package com.example.lowleveldesign.loggingframework.filter;

import com.example.lowleveldesign.loggingframework.core.LogFilter;
import com.example.lowleveldesign.loggingframework.core.LogLevel;
import com.example.lowleveldesign.loggingframework.core.LogMessage;

/**
 * Filter that filters messages based on source/class name.
 * Can include or exclude specific packages/classes.
 */
public class SourceFilter implements LogFilter {
    private String sourcePattern;
    private boolean include; // true to include matching sources, false to exclude
    private LogLevel level;

    public SourceFilter(String sourcePattern, boolean include) {
        this.sourcePattern = sourcePattern;
        this.include = include;
        this.level = LogLevel.DEBUG; // Default level
    }

    @Override
    public boolean shouldLog(LogMessage message) {
        if (message.getSource() == null) {
            return !include; // If no source, exclude if we're including, include if we're excluding
        }

        boolean matches = message.getSource().contains(sourcePattern);
        return include ? matches : !matches;
    }

    @Override
    public void setLevel(LogLevel level) {
        this.level = level;
    }

    @Override
    public LogLevel getLevel() {
        return level;
    }

    public String getSourcePattern() {
        return sourcePattern;
    }

    public void setSourcePattern(String sourcePattern) {
        this.sourcePattern = sourcePattern;
    }

    public boolean isInclude() {
        return include;
    }

    public void setInclude(boolean include) {
        this.include = include;
    }
} 
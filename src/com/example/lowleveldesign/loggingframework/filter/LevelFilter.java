package com.example.lowleveldesign.loggingframework.filter;

import com.example.lowleveldesign.loggingframework.core.LogFilter;
import com.example.lowleveldesign.loggingframework.core.LogLevel;
import com.example.lowleveldesign.loggingframework.core.LogMessage;

/**
 * Filter that only allows messages with level >= configured level.
 */
public class LevelFilter implements LogFilter {
    private LogLevel level;

    public LevelFilter() {
        this(LogLevel.DEBUG); // Default to allow all levels
    }

    public LevelFilter(LogLevel level) {
        this.level = level;
    }

    @Override
    public boolean shouldLog(LogMessage message) {
        return message.getLevel().isGreaterOrEqual(level);
    }

    @Override
    public void setLevel(LogLevel level) {
        this.level = level;
    }

    @Override
    public LogLevel getLevel() {
        return level;
    }
} 
package com.example.lowleveldesign.loggingframework.formatters;

import com.example.lowleveldesign.loggingframework.core.LogFormatter;
import com.example.lowleveldesign.loggingframework.core.LogMessage;
import java.time.format.DateTimeFormatter;

/**
 * Detailed formatter that includes source information when available.
 * Default format: "[LEVEL] TIMESTAMP [SOURCE] - MESSAGE"
 */
public class DetailedFormatter implements LogFormatter {
    private String pattern;
    private String dateFormat;
    private DateTimeFormatter dateTimeFormatter;

    public DetailedFormatter() {
        this("[%LEVEL] %TIMESTAMP [%SOURCE] - %MESSAGE");
    }

    public DetailedFormatter(String pattern) {
        this.pattern = pattern;
        this.dateFormat = "yyyy-MM-dd HH:mm:ss";
        this.dateTimeFormatter = DateTimeFormatter.ofPattern(dateFormat);
    }

    @Override
    public String format(LogMessage message) {
        if (pattern == null || pattern.isEmpty()) {
            String source = message.getSource() != null ? message.getSource() : "Unknown";
            return String.format("[%s] %s [%s] - %s", 
                message.getLevel(), 
                message.getTimestamp().toString(), 
                source,
                message.getMessage());
        }

        String formatted = pattern
            .replace("%LEVEL", message.getLevel().toString())
            .replace("%TIMESTAMP", message.getTimestamp().toString())
            .replace("%MESSAGE", message.getMessage())
            .replace("%SOURCE", message.getSource() != null ? message.getSource() : "Unknown");

        return formatted;
    }

    @Override
    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public String getPattern() {
        return pattern;
    }

    @Override
    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
        this.dateTimeFormatter = DateTimeFormatter.ofPattern(dateFormat);
    }
} 
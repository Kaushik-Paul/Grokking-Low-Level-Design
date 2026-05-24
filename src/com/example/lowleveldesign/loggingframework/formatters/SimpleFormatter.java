package com.example.lowleveldesign.loggingframework.formatters;

import com.example.lowleveldesign.loggingframework.core.LogFormatter;
import com.example.lowleveldesign.loggingframework.core.LogMessage;
import java.time.format.DateTimeFormatter;

/**
 * Simple formatter that formats log messages in a basic pattern.
 * Default format: "[LEVEL] TIMESTAMP - MESSAGE"
 */
public class SimpleFormatter implements LogFormatter {
    private String pattern;
    private String dateFormat;
    // Business use can be implemented later 
    private DateTimeFormatter dateTimeFormatter;

    public SimpleFormatter() {
        this("[%LEVEL] %TIMESTAMP - %MESSAGE");
    }

    public SimpleFormatter(String pattern) {
        this.pattern = pattern;
        this.dateFormat = "yyyy-MM-dd HH:mm:ss";
        this.dateTimeFormatter = DateTimeFormatter.ofPattern(dateFormat);
    }

    @Override
    public String format(LogMessage message) {
        if (pattern == null || pattern.isEmpty()) {
            return String.format("[%s] %s - %s", 
                message.getLevel(), 
                message.getTimestamp().toString(), 
                message.getMessage());
        }

        String formatted = pattern
            .replace("%LEVEL", message.getLevel().toString())
            .replace("%TIMESTAMP", message.getTimestamp().toString())
            .replace("%MESSAGE", message.getMessage())
            .replace("%SOURCE", message.getSource() != null ? message.getSource() : "");

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
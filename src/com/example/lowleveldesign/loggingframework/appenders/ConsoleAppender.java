package com.example.lowleveldesign.loggingframework.appenders;

import com.example.lowleveldesign.loggingframework.core.LogAppender;
import com.example.lowleveldesign.loggingframework.core.LogFormatter;
import com.example.lowleveldesign.loggingframework.core.LogLevel;
import com.example.lowleveldesign.loggingframework.core.LogMessage;
import com.example.lowleveldesign.loggingframework.formatters.SimpleFormatter;

import java.io.PrintStream;

/**
 * Appender that writes log messages to the console (System.out/System.err).
 */
public class ConsoleAppender implements LogAppender {
    private LogLevel level;
    private LogFormatter formatter;
    private PrintStream outputStream;

    public ConsoleAppender() {
        this(LogLevel.DEBUG);
    }

    public ConsoleAppender(LogLevel level) {
        this.level = level;
        this.formatter = new SimpleFormatter();
        this.outputStream = System.out;
    }

    @Override
    public void append(LogMessage message) {
        if (!isEnabled(message.getLevel())) {
            return;
        }

        String formattedMessage = formatter.format(message);
        
        // Use System.err for ERROR and FATAL levels
        if (message.getLevel() == LogLevel.ERROR || message.getLevel() == LogLevel.FATAL) {
            System.err.println(formattedMessage);
        } else {
            outputStream.println(formattedMessage);
        }
    }

    @Override
    public void setLevel(LogLevel level) {
        this.level = level;
    }

    @Override
    public LogLevel getLevel() {
        return level;
    }

    @Override
    public boolean isEnabled(LogLevel level) {
        return level.isGreaterOrEqual(this.level);
    }

    @Override
    public void setFormatter(LogFormatter formatter) {
        this.formatter = formatter;
    }

    @Override
    public LogFormatter getFormatter() {
        return formatter;
    }

    public void setOutputStream(PrintStream outputStream) {
        this.outputStream = outputStream;
    }
} 
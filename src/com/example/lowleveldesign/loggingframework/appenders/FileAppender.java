package com.example.lowleveldesign.loggingframework.appenders;

import com.example.lowleveldesign.loggingframework.core.LogAppender;
import com.example.lowleveldesign.loggingframework.core.LogFormatter;
import com.example.lowleveldesign.loggingframework.core.LogLevel;
import com.example.lowleveldesign.loggingframework.core.LogMessage;
import com.example.lowleveldesign.loggingframework.formatters.SimpleFormatter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Appender that writes log messages to a file.
 */
public class FileAppender implements LogAppender {
    private LogLevel level;
    private LogFormatter formatter;
    private String filePath;
    private PrintWriter writer;

    public FileAppender(String filePath) {
        this(filePath, LogLevel.DEBUG);
    }

    public FileAppender(String filePath, LogLevel level) {
        this.filePath = filePath;
        this.level = level;
        this.formatter = new SimpleFormatter();
        initializeWriter();
    }

    private void initializeWriter() {
        try {
            this.writer = new PrintWriter(new FileWriter(filePath, true), true);
        } catch (IOException e) {
            System.err.println("Failed to initialize FileAppender for " + filePath + ": " + e.getMessage());
        }
    }

    @Override
    public void append(LogMessage message) {
        if (!isEnabled(message.getLevel()) || writer == null) {
            return;
        }

        try {
            String formattedMessage = formatter.format(message);
            writer.println(formattedMessage);
            writer.flush();
        } catch (Exception e) {
            System.err.println("Failed to write to file " + filePath + ": " + e.getMessage());
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

    public String getFilePath() {
        return filePath;
    }

    public void close() {
        if (writer != null) {
            writer.close();
        }
    }
} 
package com.example.lowleveldesign.loggingframework.appenders;

import com.example.lowleveldesign.loggingframework.core.LogAppender;
import com.example.lowleveldesign.loggingframework.core.LogFormatter;
import com.example.lowleveldesign.loggingframework.core.LogLevel;
import com.example.lowleveldesign.loggingframework.core.LogMessage;
import com.example.lowleveldesign.loggingframework.formatters.SimpleFormatter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Appender that writes log messages to a database table.
 * Note: This is a simplified implementation. In a real scenario, you'd use a proper connection pool.
 */
public class DatabaseAppender implements LogAppender {
    private LogLevel level;
    private LogFormatter formatter;
    private Connection connection;
    private String tableName;
    private PreparedStatement insertStatement;

    public DatabaseAppender(String tableName) {
        this(tableName, LogLevel.DEBUG);
    }

    public DatabaseAppender(String tableName, LogLevel level) {
        this.tableName = tableName;
        this.level = level;
        this.formatter = new SimpleFormatter();
        // Note: In a real implementation, you'd get the connection from a pool
        this.connection = null;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
        initializeStatement();
    }

    private void initializeStatement() {
        if (connection != null) {
            try {
                String sql = "INSERT INTO " + tableName + " (timestamp, level, message, source) VALUES (?, ?, ?, ?)";
                insertStatement = connection.prepareStatement(sql);
            } catch (SQLException e) {
                System.err.println("Failed to initialize DatabaseAppender: " + e.getMessage());
            }
        }
    }

    @Override
    public void append(LogMessage message) {
        if (!isEnabled(message.getLevel()) || connection == null || insertStatement == null) {
            return;
        }

        try {
            insertStatement.setTimestamp(1, java.sql.Timestamp.from(message.getTimestamp()));
            insertStatement.setString(2, message.getLevel().toString());
            insertStatement.setString(3, message.getMessage());
            insertStatement.setString(4, message.getSource());
            insertStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Failed to write to database: " + e.getMessage());
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

    public String getTableName() {
        return tableName;
    }

    public void close() {
        if (insertStatement != null) {
            try {
                insertStatement.close();
            } catch (SQLException e) {
                System.err.println("Failed to close statement: " + e.getMessage());
            }
        }
    }
} 
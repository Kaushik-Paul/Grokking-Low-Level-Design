package com.example.lowleveldesign.logger.loggertypes;

public class LogProcessor {
    private final LogProcessor nextLogProcessor;

    public LogProcessor(LogProcessor nextLogProcessor) {
        this.nextLogProcessor = nextLogProcessor;
    }

    public static LogProcessor create() {
        return new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));
    }

    public void log(LogLevel logLevel, String message) {
        if (this.nextLogProcessor != null) {
            this.nextLogProcessor.log(logLevel, message);
        }
    }
}

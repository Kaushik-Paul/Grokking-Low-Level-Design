package com.example.lowleveldesign.logger;

import com.example.lowleveldesign.logger.loggertypes.LogLevel;
import com.example.lowleveldesign.logger.loggertypes.LogProcessor;

public class Main {

    public static void main(String[] args) {
        LogProcessor logObject = LogProcessor.create();

        logObject.log(LogLevel.ERROR, "Exception occurred");
        logObject.log(LogLevel.DEBUG, "Debug message");
        logObject.log(LogLevel.INFO, "Info message");
    }
}

package edu.hillel.lesson19.ConsolePart;

import edu.hillel.lesson19.LoggingLevel;

public class ConsoleLoggerConfiguration {
    private LoggingLevel loggingLevel;

    public ConsoleLoggerConfiguration(LoggingLevel loggingLevel) {
        this.loggingLevel = loggingLevel;
    }

    public LoggingLevel getLoggingLevel() {
        return loggingLevel;
    }
}
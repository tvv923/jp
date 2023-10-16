package edu.hillel.lesson19.FilePart;

import edu.hillel.lesson19.LoggingLevel;

public class FileLoggerConfiguration {
    private String logFilePath;
    private LoggingLevel loggingLevel;
    private long maxFileSize;
    private String logFormat;

    public FileLoggerConfiguration(String logFilePath, LoggingLevel loggingLevel, long maxFileSize, String logFormat) {
        this.logFilePath = logFilePath;
        this.loggingLevel = loggingLevel;
        this.maxFileSize = maxFileSize;
        this.logFormat = logFormat;
    }

    public String getLogFilePath() {
        return logFilePath;
    }

    public LoggingLevel getLoggingLevel() {
        return loggingLevel;
    }

    public long getMaxFileSize() {
        return maxFileSize;
    }

    public String getLogFormat() {
        return logFormat;
    }
}
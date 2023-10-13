package edu.hillel.lesson19.ConsolePart;

import edu.hillel.lesson19.AbstractLogger;
import edu.hillel.lesson19.LoggingLevel;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConsoleLogger extends AbstractLogger {
    private ConsoleLoggerConfiguration configuration;

    public ConsoleLogger(ConsoleLoggerConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public void info(String message) {
        log(LoggingLevel.INFO, message);
    }

    @Override
    public void debug(String message) {
        log(LoggingLevel.INFO, message);
        if (configuration.getLoggingLevel() == LoggingLevel.DEBUG)
            log(LoggingLevel.DEBUG, message);
    }

    protected void log(LoggingLevel level, String message) {
        System.out.println("[" + getCurrentTime() + "]" + "[" + level + "] " + "Message: " + message);
    }

    private String getCurrentTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy-HH_mm");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
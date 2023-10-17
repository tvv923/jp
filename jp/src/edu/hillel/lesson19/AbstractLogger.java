package edu.hillel.lesson19;

public abstract class AbstractLogger implements Logger {
    @Override
    public void info(String message) {
        log(LoggingLevel.INFO, message);
    }

    @Override
    public void debug(String message) {
        log(LoggingLevel.INFO, message);
        log(LoggingLevel.DEBUG, message);
    }

    protected abstract void log(LoggingLevel level, String message);
}

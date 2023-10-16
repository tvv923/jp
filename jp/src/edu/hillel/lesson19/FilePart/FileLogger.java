package edu.hillel.lesson19.FilePart;

import edu.hillel.lesson19.AbstractLogger;
import edu.hillel.lesson19.LoggingLevel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileLogger extends AbstractLogger {
    private FileLoggerConfiguration configuration;
    private FileWriter fileWriter;
    private long currentFileSize = 0;
    private String currentFileName;

    public FileLogger(FileLoggerConfiguration configuration) {
        this.configuration = configuration;
        openLogFile();
    }

    @Override
    public void info(String message) {
        log(LoggingLevel.INFO, message);
    }

    @Override
    public void debug(String message) {
        log(LoggingLevel.INFO, message);
        log(LoggingLevel.DEBUG, message);
    }

    protected void log(LoggingLevel level, String message) {
        String logMessage = "[" + getCurrentTime() + "]" + "[" + level + "] " + "Message: " + message + "\n";
        try (FileWriter fileWriter = new FileWriter(currentFileName, true)) {
            if (currentFileSize + logMessage.length() > configuration.getMaxFileSize()) {
                openLogFile();
            }
            fileWriter.write(logMessage);
            fileWriter.flush();
            currentFileSize += logMessage.length();
        } catch (IOException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    private String getCurrentTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy-HH_mm");
        Date date = new Date();
        String formattedDate = dateFormat.format(date);
        return formattedDate;
    }

    private void openLogFile() {
        File logDirectory = new File(configuration.getLogFilePath());
        File[] matchingFiles = logDirectory.listFiles(file -> {
            return file.isFile() &&
                    file.getName().startsWith(configuration.getLogFormat()) &&
                    file.length() < configuration.getMaxFileSize();
        });

        if (matchingFiles != null && matchingFiles.length > 0) {
            currentFileName = matchingFiles[0].getAbsolutePath();
        } else {
            String currentDate = getCurrentTime();
            currentFileName = configuration.getLogFilePath() + configuration.getLogFormat() + "_" + currentDate + ".txt";
        }

        try {
            fileWriter = new FileWriter(currentFileName, true);
        } catch (IOException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }
}
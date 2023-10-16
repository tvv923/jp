package edu.hillel.lesson19.FilePart;

import edu.hillel.lesson19.LoggingLevel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileLoggerConfigurationLoader {
    public FileLoggerConfiguration load(String filePath) {
        String logFilePath = "";
        LoggingLevel loggingLevel = null;
        long maxFileSize = 0;
        String logFormat = "";
        Map<String, String> CONFIG = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                final String[] properties = line.split("=");
                if (properties.length == 1)
                    throw new ArrayIndexOutOfBoundsException(String.format("Parameter %s has no value.", properties[0]));
                CONFIG.put(properties[0], properties[1]);
            }
        } catch (IOException | ArrayIndexOutOfBoundsException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }

        try {
            logFilePath = CONFIG.get("FILE");
            File logDirectory = new File(logFilePath);
            if (!logDirectory.exists()) {
                throw new IllegalArgumentException(String.format("Invalid FILE parameter: %s", logFilePath));
            }
            maxFileSize = Long.parseLong(CONFIG.get("MAX-SIZE"));
            loggingLevel = LoggingLevel.valueOf(CONFIG.get("LEVEL"));

            logFormat = CONFIG.get("FORMAT");
            if (logFormat.isEmpty())
                throw new IllegalArgumentException("Invalid FORMAT parameter.");

        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }

        return new FileLoggerConfiguration(logFilePath, loggingLevel, maxFileSize, logFormat);
    }
}

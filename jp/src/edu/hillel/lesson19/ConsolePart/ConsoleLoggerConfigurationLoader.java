package edu.hillel.lesson19.ConsolePart;

import edu.hillel.lesson19.LoggingLevel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ConsoleLoggerConfigurationLoader {
    public ConsoleLoggerConfiguration load(String filePath) {
        LoggingLevel loggingLevel;
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
            loggingLevel = LoggingLevel.valueOf(CONFIG.get("LEVEL"));
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }

        return new ConsoleLoggerConfiguration(loggingLevel);
    }
}

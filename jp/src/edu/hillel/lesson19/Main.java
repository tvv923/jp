package edu.hillel.lesson19;

import edu.hillel.lesson19.ConsolePart.ConsoleLogger;
import edu.hillel.lesson19.ConsolePart.ConsoleLoggerConfiguration;
import edu.hillel.lesson19.ConsolePart.ConsoleLoggerConfigurationLoader;
import edu.hillel.lesson19.FilePart.FileLogger;
import edu.hillel.lesson19.FilePart.FileLoggerConfiguration;
import edu.hillel.lesson19.FilePart.FileLoggerConfigurationLoader;

public class Main {
    public static void main(String[] args) {
        String pathToConfig=String.format("%s\\src\\edu\\hillel\\lesson19\\",System.getProperty("user.dir"));
        FileLoggerConfigurationLoader fileConfigurationLoader = new FileLoggerConfigurationLoader();
        String configFile = pathToConfig+ "FileConfig.txt";
        ConsoleLoggerConfigurationLoader consoleConfigurationLoader = new ConsoleLoggerConfigurationLoader();
        String configConsole = pathToConfig+ "ConsoleConfig.txt";

        try {
            FileLoggerConfiguration config1 = fileConfigurationLoader.load(configFile);
            ConsoleLoggerConfiguration config2 = consoleConfigurationLoader.load(configConsole);

            Logger logger1 = new FileLogger(config1);
            Logger logger2 = new ConsoleLogger(config2);

            logger1.info("This is INFO message.");
            logger1.debug("This is DEBUG message.");

            logger2.info("This is INFO message.");
            logger2.debug("This is DEBUG message.");

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
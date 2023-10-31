package edu.hillel.lesson24;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class FileSystemStorage implements Storage {
    private File storageDirectory;

    public FileSystemStorage(File storageDirectory) {
        this.storageDirectory = storageDirectory;
    }

    @Override
    public void put(String key, String value) {
        try (FileWriter writer = new FileWriter(new File(storageDirectory, key))) {
            writer.write(value);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String get(String key) {
        File file = new File(storageDirectory, key);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            if (line != null) {
                return line;
            }
            return null;
        }  catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
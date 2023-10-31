package edu.hillel.lesson24;

public interface Storage {
    void put(String key, String value);

    String get(String key);
}

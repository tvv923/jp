package edu.hillel.lesson24;

import java.util.HashMap;
import java.util.Map;

public class InMemoryStorage implements Storage {
    private Map<String, String> data = new HashMap<>();

    @Override
    public void put(String key, String value) {
        data.put(key, value);
    }

    @Override
    public String get(String key) {
        return data.get(key);
    }
}

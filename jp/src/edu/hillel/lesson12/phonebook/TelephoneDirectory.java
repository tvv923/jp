package edu.hillel.lesson12.phonebook;

import java.util.ArrayList;
import java.util.List;

public class TelephoneDirectory {
    private final List<Entry> entries;

    public TelephoneDirectory() {
        entries = new ArrayList<>();
    }

    public void add(Entry entry) {
        entries.add(entry);
    }

    public Entry find(String name) {
        for (Entry entry : entries) {
            if (entry.name().equals(name)) {
                return entry;
            }
        }
        return null;
    }

    public List<Entry> findAll(String name) {
        List<Entry> foundEntries = new ArrayList<>();
        for (Entry entry : entries) {
            if (entry.name().equals(name)) {
                foundEntries.add(entry);
            }
        }
        return foundEntries;
    }

    public record Entry(String name, String phoneNumber) {
    }
}
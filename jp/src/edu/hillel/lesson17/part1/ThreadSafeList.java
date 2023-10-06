package edu.hillel.lesson17.part1;

import java.util.ArrayList;
import java.util.List;

public class ThreadSafeList<T> {
    private List<T> list = new ArrayList<>();

    public synchronized void add(T item) {
        list.add(item);
    }

    public synchronized void remove(T item) {
        list.remove(item);
    }

    public synchronized T get(int index) {
        if (index >= 0 && index < list.size())
            return list.get(index);
        else
            throw new IndexOutOfBoundsException("Index out of bounds");
    }
}
package edu.hillel.lesson9;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;

public class Box<T extends Fruit> {
    private List<T> fruits;

    public Box() {
        fruits = new ArrayList<>();
    }

    public void add(T fruit) {
        fruits.add(fruit);
    }

    public void add(T[] fruits) {
        for (T fruit : fruits) {
            add(fruit);
        }
    }

    public float getWeight() {
        float totalWeight = 0;
        for (T fruit : fruits) {
            totalWeight += fruit.getWeight();
        }
        return totalWeight;
    }

    public boolean compare(Box<?> other) {
        return this.getWeight() == other.getWeight();
    }

    public void merge(Box<T> other) {
        if (this == other) {
            System.out.println("Unable to merge box to itself.");
            return;
        }
        for (T fruit : other.fruits) {
            this.add(fruit);
        }
        other.fruits.clear();
    }
}
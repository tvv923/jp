package edu.hillel.lesson4;

public class Animal {
    private static int totalAnimals = 0;
    public Animal() {
        totalAnimals++;
    }
    public void run(int distance) {
        System.out.println("Тварина може пробігти " + distance + " м.");
    }
    public void swim(int distance) {
        System.out.println("Тварина може проплисти " + distance + " м.");
    }
    public static int getTotalAnimals() {
        return totalAnimals;
    }
}

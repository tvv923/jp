package edu.hillel.lesson4;

public class Dog extends Animal {
    private static int totalDogs = 0;
    final int runLimit = 500;
    final int swimLimit = 10;
    private String name;
    public Dog(String name) {
        super();
        totalDogs++;
        this.name = name;
    }
    @Override
    public void run(int distance) {
        if (distance <= runLimit)
            System.out.println(name + "  пробіг " + distance + " м.");
        else
            System.out.println(name + "  не зміг пробігти " + distance + " м.");
    }
    @Override
    public void swim(int distance) {
        if (distance <= swimLimit)
            System.out.println(name + "  проплив " + distance + " м.");
        else
            System.out.println(name + "  не зміг пропливти " + distance + " м.");
    }
    public static int getTotalDogs() {
        return totalDogs;
    }
}
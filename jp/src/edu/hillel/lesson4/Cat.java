package edu.hillel.lesson4;

public class Cat extends Animal {
    private static int totalCats = 0;
    final int runLimit = 200;
    private String name;
    public Cat(String name) {
        super();
        totalCats++;
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
        System.out.println(name + "  не вміє плавати.");
    }
    public static int getTotalCats() {
        return totalCats;
    }
}


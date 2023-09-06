package edu.hillel.lesson4;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Бобік");
        Cat cat = new Cat("Мурзік");

        dog.run(400);
        dog.swim(5);

        cat.run(150);
        cat.swim(3);

        System.out.println("Створено собак: " + Dog.getTotalDogs());
        System.out.println("Створено котів: " + Cat.getTotalCats());
        System.out.println("Створено тварин: " + Animal.getTotalAnimals());

    }
}

package edu.hillel.coffee.order;

public class Main {
    public static void main(String[] args) {
        CoffeeOrderBoard coffeeOrderBoard = new CoffeeOrderBoard();

        coffeeOrderBoard.add(new Order(4, "Alen"));
        coffeeOrderBoard.add(new Order(27, "Yoda"));
        coffeeOrderBoard.add(new Order(33, "Obi-van"));
        coffeeOrderBoard.add(new Order(34, "John Snow"));

        coffeeOrderBoard.draw();

        coffeeOrderBoard.deliver();
        coffeeOrderBoard.draw();

        coffeeOrderBoard.deliver(33);
        coffeeOrderBoard.draw();

        coffeeOrderBoard.deliver(10);
    }
}
package edu.hillel.lesson14;

public class Main {
    public static void main(String[] args) {
        CoffeeOrderBoard orderBoard = new CoffeeOrderBoard();

        orderBoard.add(new Order("Alen"));
        orderBoard.add(new Order("Yoda"));
        orderBoard.add(new Order("Obi-van"));
        orderBoard.add(new Order("John Snow"));

        orderBoard.draw();

        orderBoard.deliver();

        orderBoard.draw();

        orderBoard.deliver(3);

        orderBoard.draw();
    }
}
package edu.hillel.lesson5.part1;

public class Square implements GeometricShape {
    private final double side;

    public Square(double side) {
        this.side = side;
    }

    public double calculateArea() {
        return side * side;
    }
}

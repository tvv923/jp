package edu.hillel.lesson5.part1;

public class Circle implements GeometricShape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

package edu.hillel.lesson23.Strategy;

public class TriangleAreaCalculation implements AreaCalculationStrategy {
    private double base;
    private double height;

    public TriangleAreaCalculation(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public double calculateArea() {
        return 0.5 * base * height;
    }
}

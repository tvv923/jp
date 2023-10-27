package edu.hillel.lesson23.Strategy;

public class RectangleAreaCalculation implements AreaCalculationStrategy {
    private double width;
    private double height;

    public RectangleAreaCalculation(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double calculateArea() {
        return width * height;
    }
}
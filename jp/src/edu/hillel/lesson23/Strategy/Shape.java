package edu.hillel.lesson23.Strategy;

public class Shape {
    private AreaCalculationStrategy calculationStrategy;

    public void setCalculationStrategy(AreaCalculationStrategy calculationStrategy) {
        this.calculationStrategy = calculationStrategy;
    }

    public double calculateArea() {
        return calculationStrategy.calculateArea();
    }
}

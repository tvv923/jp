package edu.hillel.lesson5.part1;

public class TotalCalculator {
    public double calculateTotalArea(GeometricShape[] shapes) {
        double totalArea = 0;
        for (GeometricShape shape : shapes) {
            totalArea += shape.calculateArea();
        }
        return totalArea;
    }
}

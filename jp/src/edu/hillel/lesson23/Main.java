package edu.hillel.lesson23;

import edu.hillel.lesson23.Builder.Car;
import edu.hillel.lesson23.Builder.CarBuilder;
import edu.hillel.lesson23.Factory.ChairFactory;
import edu.hillel.lesson23.Factory.Furniture;
import edu.hillel.lesson23.Factory.FurnitureFactory;
import edu.hillel.lesson23.Factory.TableFactory;
import edu.hillel.lesson23.Strategy.RectangleAreaCalculation;
import edu.hillel.lesson23.Strategy.Shape;
import edu.hillel.lesson23.Strategy.TriangleAreaCalculation;

public class Main {
    public static void main(String[] args) {
        FurnitureFactory chairFactory = new ChairFactory();
        Furniture chair = chairFactory.createFurniture();
        chair.assemble();

        FurnitureFactory tableFactory = new TableFactory();
        Furniture table = tableFactory.createFurniture();
        table.assemble();

        Car car = new CarBuilder()
                .setBody("Sedan")
                .setEngine("V6")
                .setWheels("Alloy")
                .build();
        System.out.println(car);

        Shape rectangle = new Shape();
        rectangle.setCalculationStrategy(new RectangleAreaCalculation(4, 6));
        System.out.println("Rectangle Area: " + rectangle.calculateArea());

        Shape triangle = new Shape();
        triangle.setCalculationStrategy(new TriangleAreaCalculation(3, 5));
        System.out.println("Triangle Area: " + triangle.calculateArea());
    }
}

package edu.hillel.lesson23;

import edu.hillel.lesson23.Builder.Car;
import edu.hillel.lesson23.Builder.CarBuilder;
import edu.hillel.lesson23.Factory.Furniture;
import edu.hillel.lesson23.Factory.FurnitureFactory;
import edu.hillel.lesson23.Factory.FurnitureType;
import edu.hillel.lesson23.Strategy.RectangleAreaCalculation;
import edu.hillel.lesson23.Strategy.Shape;
import edu.hillel.lesson23.Strategy.TriangleAreaCalculation;

public class Main {
    public static void main(String[] args) {
        try {
            FurnitureFactory factory = new FurnitureFactory();
            Furniture chair = factory.createFurniture(FurnitureType.CHAIR);
            Furniture table = factory.createFurniture(FurnitureType.TABLE);
            Furniture sofa = factory.createFurniture(FurnitureType.SOFA);

            chair.assemble();
            table.assemble();
            sofa.assemble();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

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

package edu.hillel.lesson23.Factory;

public class ChairFactory extends FurnitureFactory {
    @Override
    public Furniture createFurniture() {
        return new Chair();
    }
}

package edu.hillel.lesson23.Factory;

public class FurnitureFactory {
    public Furniture createFurniture(FurnitureType fType) {
        return switch (fType) {
            case CHAIR -> new Chair();
            case TABLE -> new Table();
            case SOFA -> new Sofa();
            default -> throw new IllegalArgumentException("Wrong furniture type: " + fType);
        };
    }
}

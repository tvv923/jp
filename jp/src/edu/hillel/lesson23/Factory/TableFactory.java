package edu.hillel.lesson23.Factory;

public class TableFactory extends FurnitureFactory {
    @Override
    public Furniture createFurniture() {
        return new Table();
    }
}

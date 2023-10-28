package edu.hillel.lesson23.Factory;

public class Table implements Furniture {
    @Override
    public void assemble() {
        System.out.println("Assembling a table.");
    }
}

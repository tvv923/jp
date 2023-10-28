package edu.hillel.lesson23.Factory;

public class Chair implements Furniture {
    @Override
    public void assemble() {
        System.out.println("Assembling a chair.");
    }
}

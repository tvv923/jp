package edu.hillel.lesson23.Factory;

class Table implements Furniture {
    @Override
    public void assemble() {
        System.out.println("Assembling a table.");
    }
}
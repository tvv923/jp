package edu.hillel.lesson16;

public class Main {
    public static void main(String[] args) {
        try {
            int size = 2000000;
            ValueCalculator calculator = new ValueCalculator(size);
            calculator.calculateValues();
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Execution error: " + e.getMessage());
        }
    }
}

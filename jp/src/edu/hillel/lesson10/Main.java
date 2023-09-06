package edu.hillel.lesson10;

import org.example.utils.MathOperations;

public class Main {
    public static void main(String[] args) {
        double a = 5;
        double b = 2;
        double c = 0;

        try {
            System.out.print(a + " + " + b + ": ");
            System.out.println(MathOperations.doOperation(a, b, '+'));

            System.out.print(a + " - " + b + ": ");
            System.out.println(MathOperations.doOperation(a, b, '-'));

            System.out.print(a + " * " + b + ": ");
            System.out.println(MathOperations.doOperation(a, b, '*'));

            System.out.print(a + " / " + c + ": ");
            System.out.println(MathOperations.doOperation(a, c, '/'));
        } catch (IllegalArgumentException e) {
            System.out.println("Exception: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception: " + e.getMessage());
        }
    }
}
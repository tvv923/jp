package org.example.utils;

public class MathOperations {
    public static double doOperation(double a, double b, char operator) {
        switch (operator) {
            case '+':
                return Math.addExact((int) a, (int) b);
            case '-':
                return Math.subtractExact((int) a, (int) b);
            case '*':
                return Math.multiplyExact((int) a, (int) b);
            case '/':
                if (b == 0) {
                    throw new IllegalArgumentException("Division by zero is not allowed");
                }
                return a / b;
            default:
                throw new IllegalArgumentException("Unknown operation: " + operator);
        }
    }
}

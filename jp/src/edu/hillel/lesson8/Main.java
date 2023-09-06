package edu.hillel.lesson8;

public class Main {
    public static void main(String[] args) {
        String[][] array = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };
        ArrayValueCalculator avc = new ArrayValueCalculator();

        try {
            int result = avc.doCalc(array);
            System.out.println("Sum of array elements: " + result);
        } catch (ArraySizeException | ArrayDataException e) {
            System.out.println("Error: " + e.getMessage());
            if (e.getCause() != null) {
                System.out.println("Caused by: " + e.getCause().getMessage());
            }
        }
    }
}

package edu.hillel.lesson6;
public class HomeWorkApp {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        System.out.println(isSumInRange(5, 15));
        printNumberType(10);
        System.out.println(isNegative(-5));
        printStringMultipleTimes("Hello, World!", 3);
        System.out.println(isLeapYear(2024));
    }

    public static void printThreeWords() {
        System.out.println("Orange\nBanana\nApple");
    }

    public static void checkSumSign() {
        int a = 10;
        int b = -5;
        int sum = a + b;
        System.out.print(a + " + " + b + ": ");
        if (sum >= 0) {
            System.out.println("sum is positive");
        } else {
            System.out.println("sum is negative");
        }
    }

    public static void printColor() {
        int value = 75;
        System.out.print(value + ": ");
        if (value <= 0) {
            System.out.println("red");
        } else if (value <= 100) {
            System.out.println("yellow");
        } else {
            System.out.println("green");
        }
    }

    public static void compareNumbers() {
        int a = 7;
        int b = 3;
        System.out.print("a=" + a + ", b=" + b + ": ");
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    public static boolean isSumInRange(int num1, int num2) {
        int sum = num1 + num2;
        System.out.print("Sum=" + sum + " in range 10..20: ");
        return sum >= 10 && sum <= 20;
    }

    public static void printNumberType(int num) {
        System.out.print(num + ": ");
        if (num >= 0) {
            System.out.println("positive number");
        } else {
            System.out.println("negative number");
        }
    }

    public static boolean isNegative(int num) {
        System.out.print(num + ": ");
        return num < 0;
    }

    public static void printStringMultipleTimes(String text, int times) {
        for (int i = 0; i < times; i++) {
            System.out.println(text);
        }
    }

    public static boolean isLeapYear(int year) {
        System.out.print("Is " + year + " leap year: ");
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
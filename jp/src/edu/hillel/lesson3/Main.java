package edu.hillel.lesson3;

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee("Alan Smith", "Manager", "alan@example.com", "123-456-7890", 30);
        System.out.println("Employee:");
        System.out.println("Full Name: " + employee.getFullName());
        System.out.println("Position: " + employee.getPosition());
        System.out.println("Email: " + employee.getEmail());
        System.out.println("Phone Number: " + employee.getPhoneNumber());
        System.out.println("Age: " + employee.getAge());

        Car car = new Car();
        System.out.println("\nStarting the car:");
        car.start();

        edu.hillel.lesson3.package1.SameName.printInfo();
        edu.hillel.lesson3.package2.SameName.printInfo();
    }
}
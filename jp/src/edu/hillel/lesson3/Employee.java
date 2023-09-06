package edu.hillel.lesson3;

public class Employee {
    private String fullName;
    private String position;
    private String email;
    private String phoneNumber;
    private int age;
    public Employee(String fullName, String position, String email, String phoneNumber, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }
    public String getFullName() {
        return fullName;
    }
    public String getPosition() {
        return position;
    }
    public String getEmail() {
        return email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public int getAge() {
        return age;
    }
}

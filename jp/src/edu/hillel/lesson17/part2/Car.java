package edu.hillel.lesson17.part2;

public class Car {
    private String model;
    private int fuelAmount;
    private String fuelType;

    public Car(String model, int fuelAmount, String fuelType) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelType = fuelType;

    }

    public String getModel() {
        return model;
    }

    public int getFuelAmount() {
        return fuelAmount;
    }

    public String getFuelType() {
        return fuelType;
    }
}
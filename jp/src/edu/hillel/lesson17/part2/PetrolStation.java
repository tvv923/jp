package edu.hillel.lesson17.part2;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PetrolStation {
    private Map<String, Integer> fuelInventory = new ConcurrentHashMap<>();

    public PetrolStation(Map<String, Integer> initialFuelInventory) {
        this.fuelInventory.putAll(initialFuelInventory);
    }

    public void doRefuel(Car car) {
        try {
            String fuelType = car.getFuelType();
            int requiredAmount = car.getFuelAmount();

            System.out.println(car.getModel() + " arrived to refuel " + fuelType + ".");
            int refuelTime = 3000 + (int) (Math.random() * 7000);
            Thread.sleep(refuelTime);

            fuelInventory.compute(fuelType, (key, value) -> {
                int currentAmount = value;
                int remainingAmount = currentAmount - requiredAmount;
                if (remainingAmount < 0) {
                    String errorMessage = car.getModel() + " requested " + requiredAmount +
                            " liters of " + fuelType + ", but only " + currentAmount +
                            " liters are available. Unable to process the request.";
                    throw new IllegalArgumentException(errorMessage);
                } else {
                    System.out.println(car.getModel() + " received " + requiredAmount +
                            " liters of " + fuelType + ".");
                    return remainingAmount;
                }
            });
            System.out.println("Remaining fuel inventory: " + fuelInventory);

        } catch (InterruptedException e) {
            throw new RuntimeException("Error during refueling: " + e.getMessage());
        }
    }
}
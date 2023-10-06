package edu.hillel.lesson17;

import edu.hillel.lesson17.part1.ThreadSafeList;
import edu.hillel.lesson17.part2.Car;
import edu.hillel.lesson17.part2.PetrolStation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ThreadSafeList<String> threadSafeList = new ThreadSafeList<>();
        threadSafeList.add("Elem 1");
        threadSafeList.add("Elem 2");
        threadSafeList.add("Elem 3");
        try {
            System.out.println("Extracted element: " + threadSafeList.get(0));
            threadSafeList.remove("Elem 2");
            System.out.println("Extracted element: " + threadSafeList.get(2));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
        }

        int maxConcurrentRefuels = 3;
        Map<String, Integer> initialFuelInventory = new ConcurrentHashMap<>();
        initialFuelInventory.put("benzine", 50);
        initialFuelInventory.put("diesel", 50);
        initialFuelInventory.put("gas", 50);
        PetrolStation petrolStation = new PetrolStation(initialFuelInventory);

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("BMW X5", 35, "benzine"));
        cars.add(new Car("Toyota Camry", 20, "benzine"));
        cars.add(new Car("Honda Civic", 30, "diesel"));
        cars.add(new Car("Ford Mustang", 15, "gas"));
        cars.add(new Car("Volkswagen Golf", 22, "benzine"));
        cars.add(new Car("Audi A4", 18, "diesel"));
        cars.add(new Car("Chevrolet Silverado", 28, "benzine"));

        ExecutorService executor = Executors.newFixedThreadPool(maxConcurrentRefuels);
        try {
            for (Car car : cars) {
                Runnable refuelTask = () -> {
                    try {
                        petrolStation.doRefuel(car);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid fuel amount: " + e.getMessage());
                    }catch (RuntimeException e) {
                        System.out.println("Execution error: " + e.getMessage());
                    }
                };
                executor.execute(refuelTask);
            }
        }
        finally {
            executor.shutdown();
        }
    }
}

package edu.hillel.lesson15;

import java.time.LocalDateTime;

public class Product45 {
    private String type;
    private double price;
    private boolean discountable;
    private LocalDateTime dateAdded;

    public Product45(String type, double price, boolean discountable, LocalDateTime dateAdded) {
        this.type = type;
        this.price = price;
        this.discountable = discountable;
        this.dateAdded = dateAdded;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }
}

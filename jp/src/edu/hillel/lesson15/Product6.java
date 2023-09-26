package edu.hillel.lesson15;

import java.time.LocalDate;

public class Product6 {
    private int id;
    private String type;
    private double price;
    private boolean discountable;
    private LocalDate createDate;

    public Product6(int id, String type, double price, boolean discountable, LocalDate createDate) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.discountable = discountable;
        this.createDate = createDate;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public boolean isDiscountable() {
        return discountable;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }
}


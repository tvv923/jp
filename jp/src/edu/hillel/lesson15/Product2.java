package edu.hillel.lesson15;

public class Product2 {
    private String type;
    private double price;
    private boolean discountable;

    public Product2(String type, double price, boolean discountable) {
        this.type = type;
        this.price = price;
        this.discountable = discountable;
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

    public Product2 applyDiscount() {
        return new Product2(type, price * 0.9, discountable);
    }
}
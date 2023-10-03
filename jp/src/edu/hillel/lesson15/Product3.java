package edu.hillel.lesson15;

public class Product3 {
    private String type;
    private double price;
    private boolean discountable;

    public Product3(String type, double price, boolean discountable) {
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

}

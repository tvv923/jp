package edu.hillel.lesson14;

public class Order {
    private int orderNumber;
    private String name;

    public Order(String name) {
        this.name = name;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getName() {
        return name;
    }
}

package edu.hillel.coffee.order;

import org.apache.log4j.Logger;

public class Order {
    private static final Logger logger = Logger.getLogger(Order.class);

    private int orderNumber;
    private String customerName;

    public Order(int orderNumber, String customerName) {
        this.orderNumber = orderNumber;
        this.customerName = customerName;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    @Override
    public String toString() {
        return String.format("%3s | %s", orderNumber, customerName);
    }
}

package org.example.model;

import java.util.Date;
import java.util.List;

public class Order {
    private static int nextId = 1;
    private int id;
    private Date date;
    private double cost;
    private List<Product> products;

    public Order() {
        this.id = nextId++;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public double getCost() {
        return cost;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Product getProductById(int productId) {
        return products.stream()
                .filter(product -> product.getId() == productId)
                .findFirst()
                .orElse(null);
    }

    public void recalculateOrderCost() {
        this.cost = products.stream()
                .mapToDouble(Product::getCost)
                .sum();
    }
}
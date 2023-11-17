package org.example.dao;

import org.example.model.Order;
import org.example.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderRepository {
    private final Map<Integer, Order> orders;
    private final Map<Integer, Product> products;

    public OrderRepository() {
        this.orders = new HashMap<>();
        this.products = new HashMap<>();
        initializeProducts();
    }

    private void initializeProducts() {
        addProduct(new Product(1, "Toyota", 25000.0));
        addProduct(new Product(2, "Honda", 22000.0));
        addProduct(new Product(3, "Ford", 27000.0));
        addProduct(new Product(4, "Chevrolet", 26000.0));
        addProduct(new Product(5, "Nissan", 24000.0));
        addProduct(new Product(6, "Volkswagen", 28000.0));
        addProduct(new Product(7, "BMW", 35000.0));
        addProduct(new Product(8, "Mercedes-Benz", 38000.0));
    }

    private void addProduct(Product product) {
        products.put(product.getId(), product);
    }

    public Order getOrderById(int orderId) {
        return orders.get(orderId);
    }

    public List<Order> getAllOrders() {
        return new ArrayList<>(orders.values());
    }

    public void addOrder(Order order) {
        orders.put(order.getId(), order);
    }

    public Product getProductById(int productId) {
        return products.get(productId);
    }
}
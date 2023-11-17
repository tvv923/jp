package org.example.service;

import org.example.dao.OrderRepository;
import org.example.model.Order;
import org.example.model.Product;

import java.util.List;

public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order getOrderById(int orderId) {
        return orderRepository.getOrderById(orderId);
    }

    public List<Order> getAllOrders() {
        return orderRepository.getAllOrders();
    }

    public void addOrder(Order order) {
        orderRepository.addOrder(order);
    }

    public Product getProductById(int productId) {
        return orderRepository.getProductById(productId);
    }
}

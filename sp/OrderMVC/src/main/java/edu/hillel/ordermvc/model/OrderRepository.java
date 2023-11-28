package edu.hillel.ordermvc.model;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OrderRepository {
    private Map<Long, Order> orders = new HashMap<>();
    private long orderIdCounter = 1;

    public Order getOrderById(long orderId) {
        return orders.get(orderId);
    }

    public List<Order> getAllOrders() {
        return new ArrayList<>(orders.values());
    }

    public void addOrder(Order order) {
        order.setId(orderIdCounter++);
        orders.put(order.getId(), order);
    }
}

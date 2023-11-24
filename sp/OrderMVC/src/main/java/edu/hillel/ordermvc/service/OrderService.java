package edu.hillel.ordermvc.service;

import edu.hillel.ordermvc.model.Order;
import edu.hillel.ordermvc.model.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order getOrderById(long orderId) {
        return orderRepository.getOrderById(orderId);
    }

    public List<Order> getAllOrders() {
        return orderRepository.getAllOrders();
    }

    public void addOrder(Order order) {
        orderRepository.addOrder(order);
    }
}
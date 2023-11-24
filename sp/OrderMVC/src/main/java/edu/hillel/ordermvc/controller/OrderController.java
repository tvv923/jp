package edu.hillel.ordermvc.controller;

import edu.hillel.ordermvc.model.Order;
import edu.hillel.ordermvc.model.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/getOrderById/{orderId}")
    public Order getOrderById(@PathVariable long orderId) {
        return orderRepository.getOrderById(orderId);
    }

    @GetMapping("/getAllOrders")
    public List<Order> getAllOrders() {
        return orderRepository.getAllOrders();
    }

    @PostMapping("/addOrder")
    public void addOrder(@RequestBody Order order) {
        orderRepository.addOrder(order);
    }
}
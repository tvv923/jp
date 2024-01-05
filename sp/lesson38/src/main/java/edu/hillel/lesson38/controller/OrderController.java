package edu.hillel.lesson38.controller;

import edu.hillel.lesson38.model.Order;
import edu.hillel.lesson38.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    private static final Logger logger = LogManager.getLogger(OrderController.class);
    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        logger.info("Getting order by ID: {}", id);
        return orderService.getById(id);
    }

    @GetMapping("/all")
    public List<Order> getAllOrders() {
        logger.info("Getting all orders");
        return orderService.getAllOrders();
    }

    @PostMapping("/add")
    public void addOrder(@RequestBody Order order) {
        logger.info("Adding new order: {}", order);
        orderService.addOrder(order);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOrder(@PathVariable Long id) {
        logger.info("Deleting order with ID: {}", id);
        orderService.deleteOrder(id);
    }
}
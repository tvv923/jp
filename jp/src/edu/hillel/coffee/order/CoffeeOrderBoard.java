package edu.hillel.coffee.order;

import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.Queue;

public class CoffeeOrderBoard {
    private static final Logger logger = Logger.getLogger(CoffeeOrderBoard.class);

    private Queue<Order> orderQueue;

    public CoffeeOrderBoard() {
        this.orderQueue = new LinkedList<>();
    }

    public void add(Order order) {
        orderQueue.add(order);
        logger.info("Order added - " + order);
    }

    public void deliver() {
        if (!orderQueue.isEmpty()) {
            Order deliveredOrder = orderQueue.poll();
            logger.info("Order delivered - " + deliveredOrder);
        } else
            logger.info("No orders to deliver");
    }

    public void deliver(int orderNumber) {
        try {
            Order orderToRemove = orderQueue.stream()
                    .filter(order -> order.getOrderNumber() == orderNumber)
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Order not found"));

            orderQueue.remove(orderToRemove);
            logger.info("Order delivered - " + orderToRemove);
        } catch (Exception e) {
            logger.error("Error delivering order with number " + orderNumber, e);
        }
    }

    public void draw() {
        logger.info("Current state of the queue:");
        logger.info("===============");
        logger.info("Num | Name ");

        for (Order order : orderQueue) {
            logger.info(order.toString());
        }
    }
}


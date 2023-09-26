package edu.hillel.lesson14;
import java.util.LinkedList;
import java.util.Queue;

public class CoffeeOrderBoard {
    private Queue<Order> orders;
    private int nextOrderNumber;

    public CoffeeOrderBoard() {
        this.orders = new LinkedList<>();
        this.nextOrderNumber = 1;
    }

    public void add(Order order) {
        order.setOrderNumber(nextOrderNumber++);
        orders.offer(order);
    }

    public void deliver() {
        Order orderToDeliver = orders.poll();
        if (orderToDeliver != null) {
            System.out.println("Delivering order #" + orderToDeliver.getOrderNumber() + " for " + orderToDeliver.getName());
        } else {
            System.out.println("No orders to deliver.");
        }
    }

    public void deliver(int orderNumber) {
        for (Order order : orders) {
            if (order.getOrderNumber() == orderNumber) {
                System.out.println("Delivering order #" + order.getOrderNumber() + " for " + order.getName());
                orders.remove(order);
                return;
            }
        }
        System.out.println("Order #" + orderNumber + " not found.");
    }

    public void draw() {
        System.out.println("===============");
        System.out.println("Num | Name");
        for (Order order : orders) {
            System.out.println(String.format("%3s", order.getOrderNumber()) + " | " + order.getName());
        }
    }
}

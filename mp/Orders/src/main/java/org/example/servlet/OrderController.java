package org.example.servlet;

import com.google.gson.Gson;
import org.example.dao.OrderRepository;
import org.example.model.Order;
import org.example.model.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.service.OrderService;

@WebServlet("/order")
public class OrderController extends HttpServlet {
    private final OrderService orderService;

    public OrderController() {
        this.orderService = new OrderService(new OrderRepository());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try (PrintWriter out = response.getWriter()) {
            String orderIdParam = request.getParameter("id");
            response.setContentType("text/html");

            if (orderIdParam != null) {
                int orderId = Integer.parseInt(orderIdParam);
                Order order = orderService.getOrderById(orderId);

                if (order != null) {
                    printOrderDetails(out, order);
                } else {
                    out.println("<html><body>");
                    out.println("<p>Order not found</p>");
                    out.println("</body></html>");
                }
            } else {
                List<Order> allOrders = orderService.getAllOrders();

                out.println("<html><body>");
                out.println("<h2>All Orders</h2>");
                for (Order order : allOrders) {
                    printOrderDetails(out, order);
                    out.println("<hr>");
                }
                out.println("</body></html>");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        BufferedReader reader = request.getReader();
        StringBuilder jsonStringBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            jsonStringBuilder.append(line);
        }
        Order order = new Gson().fromJson(jsonStringBuilder.toString(), Order.class);

        List<Integer> productIds = order.getProducts().stream()
                .map(Product::getId)
                .collect(Collectors.toList());

        if (productIds != null) {
            List<Product> productsFromRepository = productIds.stream()
                    .map(orderService::getProductById)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());

            if (!productsFromRepository.isEmpty()) {
                for (Product product : productsFromRepository) {
                    Product existingProductInOrder = order.getProductById(product.getId());
                    existingProductInOrder.setName(product.getName());
                    existingProductInOrder.setCost(product.getCost());
                }
            } else
                order.getProducts().clear();
        }

        if (!order.getProducts().isEmpty()) {
            order.recalculateOrderCost();
            orderService.addOrder(order);
            response.setStatus(HttpServletResponse.SC_CREATED);
            response.getWriter().write("Order created successfully");
        } else {
            response.setStatus(HttpServletResponse.SC_CREATED);
            response.getWriter().write("Order hasn't been created. Ordered products don't exist.");
        }
    }

    private void printOrderDetails(PrintWriter out, Order order) {
        out.println("<html><body>");

        out.println("<h2>Order Details</h2>");
        out.println("<p>ID: " + order.getId() + "</p>");
        out.println("<p>Date: " + formatDate(order.getDate()) + "</p>");
        out.println("<p>Cost: $" + order.getCost() + "</p>");

        out.println("<p>Products:</p>");
        out.println("<ul>");
        for (Product product : order.getProducts()) {
            out.println("<li>"+ product.getName() + " - $" + product.getCost() + "</li>");
        }
        out.println("</ul>");

        out.println("</body></html>");
    }

    private String formatDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }
}
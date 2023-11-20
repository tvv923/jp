package org.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.dao.OrderRepository;
import org.example.model.Product;
import org.example.service.OrderService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/product")
public class ProductController extends HttpServlet {
    private final OrderService orderService;

    public ProductController() {
        this.orderService = new OrderService(new OrderRepository());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productIdParam = request.getParameter("id");

        if (productIdParam != null && !productIdParam.isEmpty()) {
            int productId = Integer.parseInt(productIdParam);
            Product product = orderService.getProductById(productId);

            if (product != null) {
                response.setContentType("text/html");
                PrintWriter writer = response.getWriter();
                writer.println("<html><body>");
                writer.println("<h2>Product Details</h2>");
                writer.println("<p>ID: " + product.getId() + "</p>");
                writer.println("<p>Name: " + product.getName() + "</p>");
                writer.println("<p>Cost: " + product.getCost() + "</p>");
                writer.println("</body></html>");
            } else
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Product not found");

        } else {
            List<Product> allProducts = orderService.getAllProducts();

            response.setContentType("text/html");
            PrintWriter writer = response.getWriter();
            writer.println("<html><body>");
            writer.println("<h2>All Products</h2>");
            writer.println("<ul>");

            for (Product product : allProducts) {
                writer.println("<li>ID: " + product.getId() + ", Name: " + product.getName() + ", Cost: " + product.getCost() + "</li>");
            }

            writer.println("</ul>");
            writer.println("</body></html>");
        }
    }
}

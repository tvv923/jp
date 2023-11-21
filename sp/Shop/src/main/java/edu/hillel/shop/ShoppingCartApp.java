package edu.hillel.shop;

import edu.hillel.shop.controller.ShoppingCartManager;
import edu.hillel.shop.dao.ProductRepository;
import edu.hillel.shop.model.Cart;
import edu.hillel.shop.model.Product;
import edu.hillel.shop.service.ShoppingCartService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ShoppingCartApp {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingCartApp.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ShoppingCartManager shoppingCartManager) {
        return args -> shoppingCartManager.run();
    }

    @Bean
    public Cart cart() {
        return new Cart();
    }

    @Bean
    public ProductRepository productRepository() {
        List<Product> initialProducts = new ArrayList<>();
        initialProducts.add(new Product(1, "Margherita", 12.99));
        initialProducts.add(new Product(2, "Pepperoni", 14.99));
        initialProducts.add(new Product(3, "Vegetarian", 13.49));
        initialProducts.add(new Product(4, "Hawaiian", 15.49));
        initialProducts.add(new Product(5, "Supreme", 16.99));
        return new ProductRepository(initialProducts);
    }

    @Bean
    public ShoppingCartService shoppingCartService(ProductRepository productRepository, Cart cart) {
        return new ShoppingCartService(productRepository, cart);
    }

    @Bean
    public ShoppingCartManager shoppingCartManager(ShoppingCartService shoppingCartService) {
        return new ShoppingCartManager(shoppingCartService);
    }
}
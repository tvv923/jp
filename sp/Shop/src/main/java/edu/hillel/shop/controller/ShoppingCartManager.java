package edu.hillel.shop.controller;

import edu.hillel.shop.model.Product;
import edu.hillel.shop.service.ShoppingCartService;

import java.util.List;
import java.util.Scanner;

public class ShoppingCartManager {
    private final ShoppingCartService shoppingCartService;

    public ShoppingCartManager(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            System.out.print("Enter the option number: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    displayAllProducts();
                    break;
                case 2:
                    addProductToCart(scanner);
                    break;
                case 3:
                    removeProductFromCart(scanner);
                    break;
                case 4:
                    displayCartItems();
                    break;
                case 5:
                    System.out.println("Thank you for using the program. Exiting.");
                    System.exit(0);
                default:
                    System.out.println("Invalid option number. Please try again.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("----- Menu -----");
        System.out.println("1. Display all products");
        System.out.println("2. Add a product to the cart");
        System.out.println("3. Remove a product from the cart");
        System.out.println("4. Display the cart content");
        System.out.println("5. Exit");
    }

    private void displayAllProducts() {
        List<Product> products = shoppingCartService.getAllProducts();
        System.out.println("----- All Products -----");
        for (Product product : products) {
            System.out.println(product.getId() + " - " + product.getName() + " - " + product.getPrice());
        }
        System.out.println("------------------------");
    }

    private void addProductToCart(Scanner scanner) {
        System.out.print("Enter the ID of the product you want to add to the cart: ");
        int productIdToAdd = scanner.nextInt();
        scanner.nextLine();
        shoppingCartService.addProductToCart(productIdToAdd);
    }

    private void removeProductFromCart(Scanner scanner) {
        System.out.print("Enter the ID of the product you want to remove from the cart: ");
        int productIdToRemove = scanner.nextInt();
        scanner.nextLine();
        shoppingCartService.removeProductFromCart(productIdToRemove);
    }

    private void displayCartItems() {
        List<Product> cartItems = shoppingCartService.getCartItems();
        System.out.println("----- Cart Content -----");
        for (Product cartItem : cartItems) {
            System.out.println(cartItem.getId() + " - " + cartItem.getName() + " - " + cartItem.getPrice());
        }
        System.out.println("------------------------");
    }
}

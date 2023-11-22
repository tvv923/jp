package edu.hillel.shop.service;

import edu.hillel.shop.dao.ProductRepository;
import edu.hillel.shop.model.Cart;
import edu.hillel.shop.model.Product;

import java.util.List;

public class ShoppingCartService {
    private final ProductRepository productRepository;
    private final Cart cart;

    public ShoppingCartService(ProductRepository productRepository, Cart cart) {
        this.productRepository = productRepository;
        this.cart = cart;
    }

    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    public Product getProductById(int id) {
        return productRepository.getProductById(id);
    }

    public void addProductToCart(int productId) {
        Product product = getProductById(productId);
        if (product != null) {
            cart.addProduct(product);
            System.out.println("Product added to the cart.");
        } else {
            System.out.println("Product with the specified ID not found.");
        }
    }

    public void removeProductFromCart(int productId) {
        cart.removeProductById(productId);
        System.out.println("Product removed from the cart.");
    }

    public List<Product> getCartItems() {
        return cart.getCartItems();
    }
}

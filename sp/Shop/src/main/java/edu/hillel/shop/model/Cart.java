package edu.hillel.shop.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> cartItems = new ArrayList<>();

    public void addProduct(Product product) {
        cartItems.add(product);
    }

    public void removeProductById(int id) {
        cartItems.removeIf(product -> product.getId() == id);
    }

    public List<Product> getCartItems() {
        return new ArrayList<>(cartItems);
    }
}

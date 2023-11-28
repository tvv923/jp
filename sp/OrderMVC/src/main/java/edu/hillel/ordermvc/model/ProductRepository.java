package edu.hillel.ordermvc.model;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository {

    private final Map<Long, Product> products = new HashMap<>();
    private long currentId = 1;

    public List<Product> getAllProducts() {
        return new ArrayList<>(products.values());
    }

    public Product getProductById(long productId) {
        return products.get(productId);
    }

    public boolean addProduct(Product product) {
        long productId = currentId++;
        product.setId(productId);
        products.put(productId, product);
        return true;
    }
}
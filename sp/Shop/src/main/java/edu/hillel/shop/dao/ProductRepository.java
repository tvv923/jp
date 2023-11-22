package edu.hillel.shop.dao;

import edu.hillel.shop.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private List<Product> productList;

    public ProductRepository(List<Product> productList) {
        this.productList = productList;
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(productList);
    }

    public Product getProductById(int id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}
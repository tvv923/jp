package edu.hillel.lesson15;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ProductService3 {
    private List<Product3> productList = new ArrayList<>();

    public void addProduct(Product3 product) {
        productList.add(product);
    }

    public Product3 getCheapestBook(String catType) {
        try {
            return productList.stream()
                    .filter(product -> catType.equals(product.getType()))
                    .min(Comparator.comparingDouble(Product3::getPrice))
                    .get();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Product [category: " + catType + "] not found");
        }
    }
}
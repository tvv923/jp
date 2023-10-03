package edu.hillel.lesson15;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ProductService1 {
    private List<Product1> productList = new ArrayList<>();

    public void addProduct(Product1 product) {
        productList.add(product);
    }

    public Stream<Product1> getExpensiveBooks() {
        return productList.stream()
                .filter(product -> "Book".equals(product.getType()) && product.getPrice() > 250);
    }
}

package edu.hillel.lesson15;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Stream;

public class ProductService4 {
    private List<Product45> productList = new ArrayList<>();

    public void addProduct(Product45 product) {
        productList.add(product);
    }

    public Stream<Product45> getRecentProducts() {
        return productList.stream()
                .sorted(Comparator.comparing(Product45::getDateAdded).reversed())
                .limit(3);
    }
}
package edu.hillel.lesson15;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductService6 {
    private List<Product6> productList = new ArrayList<>();

    public void addProduct(Product6 product) {
        productList.add(product);
    }

    public Stream<Map<String, List<Product6>>> groupProductsByType() {
        return productList.stream()
                .collect(Collectors.groupingBy(Product6::getType))
                .entrySet()
                .stream()
                .map(entry -> {
                    Map<String, List<Product6>> groupedProduct = new HashMap<>();
                    groupedProduct.put(entry.getKey(), entry.getValue());
                    return groupedProduct;
                });
    }
}
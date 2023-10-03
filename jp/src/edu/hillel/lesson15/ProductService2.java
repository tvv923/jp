package edu.hillel.lesson15;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;

public class ProductService2 {
    private List<Product2> productList = new ArrayList<>();

    public void addProduct(Product2 product) {
        productList.add(product);
    }

    public Stream<Product2> getDiscountableBooks() {
        return productList.stream()
                .filter(product -> "Book".equals(product.getType()) && product.isDiscountable())
                .map(Product2::applyDiscount);
    }
}

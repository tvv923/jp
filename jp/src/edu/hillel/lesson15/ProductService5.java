package edu.hillel.lesson15;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ProductService5 {
    private List<Product45> productList = new ArrayList<>();

    public void addProduct(Product45 product) {
        productList.add(product);
    }

    public double calculateTotalPriceForBooksAddedThisYear() {
        LocalDateTime currentYearStart = LocalDateTime.now().withDayOfYear(1).withHour(0).withMinute(0).withSecond(0).withNano(0);

        return productList.stream()
                .filter(product -> "Book".equals(product.getType()))
                .filter(product -> product.getDateAdded().isAfter(currentYearStart))
                .filter(product -> product.getPrice() <= 75)
                .mapToDouble(Product45::getPrice)
                .sum();
    }
}

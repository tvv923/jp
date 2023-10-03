package edu.hillel.lesson15;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Map;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println("All products of category 'Book' and price more than 250.");
        ProductService1 pS1 = new ProductService1();
        pS1.addProduct(new Product1("Book", 300));
        pS1.addProduct(new Product1("Book", 200));
        pS1.addProduct(new Product1("Toy", 150));
        Stream<Product1> expensiveBooks = pS1.getExpensiveBooks();
        expensiveBooks.forEach(product -> System.out.println("Type: " + product.getType() + ", Price: " + product.getPrice()));

        System.out.println("\nBooks with discount.");
        ProductService2 pS2 = new ProductService2();
        pS2.addProduct(new Product2("Book", 100, true));
        pS2.addProduct(new Product2("Book", 200, false));
        pS2.addProduct(new Product2("Toy", 150, true));
        Stream<Product2> discountableBooks = pS2.getDiscountableBooks();
        discountableBooks.forEach(product -> System.out.println("Type: " + product.getType() + ", Price: " + product.getPrice()));

        ProductService3 pS3 = new ProductService3();
        pS3.addProduct(new Product3("Book", 100, true));
        pS3.addProduct(new Product3("Book", 200, false));
        pS3.addProduct(new Product3("Toy", 150, true));
        try {
            Product3 cheapestBook = pS3.getCheapestBook("Book");
            System.out.println("\nCheapest book: Type - " + cheapestBook.getType() + ", Price - " + cheapestBook.getPrice());
        } catch (NoSuchElementException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("\nLast 3 added products.");
        ProductService4 pS4 = new ProductService4();
        LocalDateTime lt = LocalDateTime.now();
        pS4.addProduct(new Product45("Book", 100, true, lt.minusHours(1)));
        pS4.addProduct(new Product45("Toy", 50, false, lt.minusMinutes(30)));
        pS4.addProduct(new Product45("Book", 200, false, lt.minusMinutes(15)));
        pS4.addProduct(new Product45("Electronics", 500, true, lt));
        Stream<Product45> recentProducts = pS4.getRecentProducts();
        recentProducts.forEach(product -> {
            System.out.println("Type: " + product.getType() + ", Price: " + product.getPrice() + ", Adding date: " +
                    product.getDateAdded().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        });

        ProductService5 pS5 = new ProductService5();
        pS5.addProduct(new Product45("Book", 60, true, lt.minusMonths(2)));
        pS5.addProduct(new Product45("Book", 80, false, lt.minusDays(50)));
        pS5.addProduct(new Product45("Book", 70, true, lt.minusWeeks(3)));
        pS5.addProduct(new Product45("Toy", 50, false, lt.minusYears(1)));
        double totalPrice = pS5.calculateTotalPriceForBooksAddedThisYear();
        System.out.println("\nTotal price for added this year books with price not more then 75: " + totalPrice);

        System.out.println("\nGrouping products by type.");
        ProductService6 pS6 = new ProductService6();
        pS6.addProduct(new Product6(1, "Book", 100, false, LocalDate.of(2022, 1, 1)));
        pS6.addProduct(new Product6(2, "Toy", 200, true, LocalDate.of(2022, 2, 15)));
        pS6.addProduct(new Product6(3, "Book", 150, true, LocalDate.of(2022, 3, 10)));
        pS6.addProduct(new Product6(4, "Toy", 80, false, LocalDate.of(2022, 1, 5)));
        pS6.addProduct(new Product6(5, "Book", 120, true, LocalDate.of(2022, 4, 20)));
        Stream<Map<String, List<Product6>>> groupedProductsStream = pS6.groupProductsByType();
        groupedProductsStream.forEach(groupedProduct -> {
            groupedProduct.forEach((type, products) -> {
                System.out.println(type + ":");
                products.forEach(product -> {
                    System.out.println("  {type: " + product.getType() + ", price: " + product.getPrice() +
                            ", discount: " + product.isDiscountable() + ", createDate: " + product.getCreateDate() + "}");
                });
            });
        });
    }
}

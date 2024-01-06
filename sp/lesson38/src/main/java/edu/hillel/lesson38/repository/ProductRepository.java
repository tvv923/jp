package edu.hillel.lesson38.repository;

import edu.hillel.lesson38.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

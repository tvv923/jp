package edu.hillel.lesson35.repository;

import edu.hillel.lesson35.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}


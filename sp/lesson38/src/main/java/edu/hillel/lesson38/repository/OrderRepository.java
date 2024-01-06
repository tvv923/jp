package edu.hillel.lesson38.repository;

import edu.hillel.lesson38.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}

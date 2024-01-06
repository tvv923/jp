package edu.hillel.lesson38.controller;

import edu.hillel.lesson38.model.Product;
import edu.hillel.lesson38.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    private static final Logger logger = LogManager.getLogger(ProductController.class);

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        logger.info("Getting product by ID: {}", id);
        return productService.getProductById(id);
    }

    @GetMapping("/all")
    public List<Product> getAllProducts() {
        logger.info("Getting all products");
        return productService.getAllProducts();
    }

    @PostMapping("/add")
    public void addProduct(@RequestBody Product product) {
        logger.info("Adding new product: {}", product);
        productService.addProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Long id) {
        logger.info("Deleting product with ID: {}", id);
        productService.deleteProduct(id);
    }
}

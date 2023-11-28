package edu.hillel.ordermvc.controller;

import edu.hillel.ordermvc.model.Product;
import edu.hillel.ordermvc.model.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/getAllProducts")
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    @GetMapping("/getProductById/{productId}")
    public Product getProductById(@PathVariable long productId) {
        return productRepository.getProductById(productId);
    }

    @PostMapping("/addProduct")
    public void addProduct(@RequestBody Product product) {
        productRepository.addProduct(product);
    }
}

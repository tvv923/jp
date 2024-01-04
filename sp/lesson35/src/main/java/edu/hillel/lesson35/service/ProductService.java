package edu.hillel.lesson35.service;

import edu.hillel.lesson35.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    List<ProductDTO> getAllProducts();

    ProductDTO getProductById(Long id);

    ProductDTO addProduct(ProductDTO product);

    void deleteProduct(Long id);
}

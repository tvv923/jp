package edu.hillel.lesson35.service;

import edu.hillel.lesson35.dto.ProductDTO;
import edu.hillel.lesson35.model.Product;
import edu.hillel.lesson35.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream()
                .map(ProductDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO getProductById(Long id) {
        return productRepository.findById(id)
                .map(ProductDTO::fromEntity)
                .orElse(null);
    }

    @Override
    public ProductDTO addProduct(ProductDTO productDTO) {
        Product product = productRepository.save(productDTO.toEntity());
        return ProductDTO.fromEntity(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}

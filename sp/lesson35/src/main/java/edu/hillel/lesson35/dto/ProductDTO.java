package edu.hillel.lesson35.dto;

import edu.hillel.lesson35.model.Product;

public class ProductDTO {

    private Long id;
    private String name;
    private double cost;

    public ProductDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public static ProductDTO fromEntity(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setCost(product.getCost());
        return dto;
    }

    public Product toEntity() {
        Product product = new Product();
        product.setId(this.getId());
        product.setName(this.getName());
        product.setCost(this.getCost());
        return product;
    }
}


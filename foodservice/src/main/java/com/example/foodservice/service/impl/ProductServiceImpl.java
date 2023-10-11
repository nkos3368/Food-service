package com.example.foodservice.service.impl;

import com.example.foodservice.model.Product;
import com.example.foodservice.repository.ProductRepository;
import com.example.foodservice.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            Product productToUpdate = productOptional.get();
            productToUpdate.setImageUrl(product.getImageUrl());
            productToUpdate.setDescription(product.getDescription());
            return productRepository.save(productToUpdate);
        }
        return null;
    }

    @Override
    public Product deleteProduct(Long id) {
        productRepository.deleteById(id);
        return null;
    }

    @Override
    public Collection<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getOneProduct(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        return productOptional.orElse(null);
    }
}

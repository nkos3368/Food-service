package com.example.foodservice.service;

import com.example.foodservice.model.Product;

import java.util.Collection;

public interface ProductService {
    public abstract Product createProduct(Product product);
    public abstract Product updateProduct(Long id, Product product);
    public abstract Product deleteProduct(Long id);
    public abstract Collection<Product> getAllProducts();
    public abstract Product getOneProduct(Long id);
}

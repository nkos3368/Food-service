package com.example.foodservice.controller;

import com.example.foodservice.model.Product;
import com.example.foodservice.repository.ProductRepository;
import com.example.foodservice.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/rest/product")
@CrossOrigin
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductRepository productRepository, ProductService productService) {
        this.productService = productService;

    }

    @GetMapping
    public ResponseEntity<Collection<Product>> getAllProducts() {
        Collection<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("{id}")
    public ResponseEntity getOneProduct(@PathVariable Long id) {
        Product product = productService.getOneProduct(id);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity createProduct(@RequestBody Product product) {
        Product createdProduct = productService.createProduct(product);
        return ResponseEntity.status(201).body(createdProduct);
    }

    @PatchMapping("{id}")
    public ResponseEntity updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(id, product);
        if (updatedProduct != null) {
            return ResponseEntity.ok(updatedProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteProduct(@PathVariable Long id) {
        Product product = productService.deleteProduct(id);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

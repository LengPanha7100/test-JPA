package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.model.ProductDto;
import com.example.demo.model.ProductResponse;

import java.util.List;
import java.util.Optional;

public interface ServiceProduct {
    ProductDto createProduct(ProductResponse productResponse);

    List<Product> getAllProduct();

    Optional<Product> getProductById(Long id);

    Product updateProduct(ProductResponse productResponse, Long id);

    Product deleteProduct(Long id);
}

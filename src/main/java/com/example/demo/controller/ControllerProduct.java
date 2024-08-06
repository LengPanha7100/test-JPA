package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.model.ProductResponse;
import com.example.demo.repository.RepositoryProduct;
import com.example.demo.service.ServiceProduct;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/product")
public class ControllerProduct {
    private final ServiceProduct serviceProduct;

    @GetMapping
    public ResponseEntity<?> getAllProduct(){
        List<Product> products = serviceProduct.getAllProduct();
        return ResponseEntity.ok(products);
    }

    @PostMapping
    public ResponseEntity<?> createProduct (@RequestBody ProductResponse productResponse){
        Product product = serviceProduct.createProduct(productResponse);
        return ResponseEntity.ok(product);

    }

    @GetMapping("{id}")
    public ResponseEntity<?> getProductById (@PathVariable Long id){
        Optional<Product> product = serviceProduct.getProductById(id);
        return ResponseEntity.ok(product);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateProduct (@RequestBody ProductResponse productResponse , @PathVariable Long id){
        Product product = serviceProduct.updateProduct(productResponse,id);
        return  ResponseEntity.ok(product);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteProduct (@PathVariable Long id){
        Product product = serviceProduct.deleteProduct(id);
        return ResponseEntity.ok(product);
    }


}

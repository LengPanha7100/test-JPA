package com.example.demo.service.serviceImp;

import com.example.demo.exception.CustomNotfoundException;
import com.example.demo.model.Product;
import com.example.demo.model.ProductResponse;
import com.example.demo.repository.RepositoryProduct;
import com.example.demo.service.ServiceProduct;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ServiceImpProduct implements ServiceProduct {
    private final RepositoryProduct repositoryProduct;

    @Override
    public Product createProduct(ProductResponse productResponse) {
        Product product = new Product();
        product.setName(productResponse.getName());
        product.setPrice(productResponse.getPrice());
        return repositoryProduct.save(product);
    }

    @Override
    public List<Product> getAllProduct() {
        return repositoryProduct.findAll();
    }

    @Override
    public Optional<Product> getProductById(Long id) {
//        Optional<Product> productById = repositoryProduct.findById(id);
//        if(!productById.isPresent()){
//            throw new EntityNotFoundException("product is not find !");
//        }

        return Optional.ofNullable(repositoryProduct.findById(id).orElseThrow(
                () -> new CustomNotfoundException("Product is not found !")
        ));


    }

    @Override
    public Product updateProduct(ProductResponse productResponse, Long id) {
         Optional<Product> productById = getProductById(id);
         Product product = productById.get();
         product.setName(productResponse.getName());
         product.setPrice(productResponse.getPrice());
         return repositoryProduct.save(product);

    }

    @Override
    public Product deleteProduct(Long id) {
        Optional<Product> deleteProduct = getProductById(id);
        if(!deleteProduct.isPresent()){
            throw new CustomNotfoundException("You can not delete product!");
        }
        Product productToDelete = deleteProduct.get();
        repositoryProduct.deleteById(id);
        return productToDelete;

    }

//    @Override
//    public Product updateProduct(ProductResponse productResponse, Integer id) {
//
//    }

//    @Override
//    public List<Product> getAllProduct() {
//        return repositoryProduct.getAllProduct();
//    }
}

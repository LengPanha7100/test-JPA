package com.example.demo.repository;

import com.example.demo.model.Product;
import com.example.demo.model.ProductResponse;
import org.apache.ibatis.annotations.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryProduct extends JpaRepository<Product,Long> {

//    @Select("""
//        INSERT INTO product(product_name, price)
//        values (#{Product.name},#{Product.price})
//        RETURNING *;
//    """)
//    @Result(property = "name",column = "product_name")
//    Product createProduct(@Param("Product") ProductResponse productResponse);
//
//    @Select("""
//         SELECT  * FROM product;
//    """)
//    @Result(property = "name",column = "product_name")
//    List<Product> getAllProduct();
}

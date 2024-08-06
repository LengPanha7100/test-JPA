package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private String name;
    private BigDecimal price ;

    public Product toEntity(){
        return new Product(null,name,price);
    }
    public Product toEntity(Long id){
        return new Product(id,name,price);
    }
}

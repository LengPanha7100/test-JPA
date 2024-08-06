package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Table(name = "product_db" , schema = "product",catalog = "product_cal")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "product")
    @SequenceGenerator(name = "product",sequenceName = "product_seq",allocationSize = 2)

    private Long id ;

    @Column(name = "product_name",nullable = false,length = 50)
    private String name ;

    @Column(precision = 6,scale = 3)
    private BigDecimal price;
}

package com.ccsdg3.ecom.model;

import org.springframework.data.mongodb.core.mapping.DBRef;
import lombok.Data;

@Data
public class OrderItem {
    private String slug;
    private String name;
    private Integer quantity;
    private String image;
    private Double price;

    @DBRef
    private Product product;
}
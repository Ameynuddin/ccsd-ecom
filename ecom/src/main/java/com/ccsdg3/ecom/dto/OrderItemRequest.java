package com.ccsdg3.ecom.dto;

import lombok.Data;

@Data
public class OrderItemRequest {
    private String slug;
    private String name;
    private Integer quantity;
    private String image;
    private Double price;
    private String productId;
}

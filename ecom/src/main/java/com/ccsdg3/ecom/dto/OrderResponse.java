package com.ccsdg3.ecom.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import com.ccsdg3.ecom.model.Order;

@Data
@AllArgsConstructor
public class OrderResponse {
    private String message;
    private Order order;
}

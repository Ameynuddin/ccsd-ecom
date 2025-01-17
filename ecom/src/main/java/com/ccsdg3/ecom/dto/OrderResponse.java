package com.ccsdg3.ecom.dto;

import com.ccsdg3.ecom.model.Order;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {
    private String message;
    private Order order;
}

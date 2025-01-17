package com.ccsdg3.ecom.dto;

import com.ccsdg3.ecom.model.ShippingAddress;
import lombok.Data;
import java.util.List;

@Data
public class OrderRequest {
    private List<OrderItemRequest> orderItems;
    private ShippingAddress shippingAddress;
    private String paymentMethod;
    private Double itemsPrice;
    private Double shippingPrice;
    private Double taxPrice;
    private Double totalPrice;
}

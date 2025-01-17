package com.ccsdg3.ecom.model;

import java.util.Date;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Document(collection = "orders")
@Data
public class Order {
    @Id
    private String id;

    private List<OrderItem> orderItems;
    private ShippingAddress shippingAddress;
    private String paymentMethod;
    private PaymentResult paymentResult;
    private Double itemsPrice;
    private Double shippingPrice;
    private Double taxPrice;
    private Double totalPrice;

    @DBRef
    private User user;

    private boolean isPaid;
    private Date paidAt;
    private boolean isDelivered;
    private Date deliveredAt;
    private Date createdAt;
    private Date updatedAt;
}
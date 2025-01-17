package com.ccsdg3.ecom.model;

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

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;
}

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

@Data
public class ShippingAddress {
    private String fullName;
    private String address;
    private String city;
    private String postalCode;
    private String country;
}

@Data
public class PaymentResult {
    private String id;
    private String status;
    private String updateTime;
    private String emailAddress;
}

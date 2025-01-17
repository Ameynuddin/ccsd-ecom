package com.ccsdg3.ecom.model;

@Document(collection = "products")
@Data
public class Product {
    @Id
    private String id;

    @Indexed(unique = true)
    private String name;

    @Indexed(unique = true)
    private String slug;

    private String image;
    private String brand;
    private String category;
    private String description;
    private Double price;
    private Integer countInStock;
    private Double rating;
    private Integer numReviews;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;
}

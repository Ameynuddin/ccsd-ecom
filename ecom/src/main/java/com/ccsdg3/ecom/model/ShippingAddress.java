package com.ccsdg3.ecom.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShippingAddress {
    private String fullName;
    private String address;
    private String city;
    private String postalCode;
    private String country;
}
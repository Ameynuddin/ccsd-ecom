package com.ccsdg3.ecom.model;

import lombok.Data;

@Data
public class PaymentResult {
    private String id;
    private String status;
    private String updateTime;
    private String emailAddress;
}
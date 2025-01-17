package com.ccsdg3.ecom.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentResult {
    private String id;
    private String status;
    private String updateTime;
    private String emailAddress;
}
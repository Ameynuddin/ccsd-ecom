package com.ccsdg3.ecom.dto;

import lombok.Data;

@Data
public class PaymentResultDTO {
    private String id;
    private String status;
    private String updateTime;
    private String emailAddress;
}

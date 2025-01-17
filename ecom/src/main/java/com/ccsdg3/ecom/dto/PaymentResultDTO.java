package com.ccsdg3.ecom.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentResultDTO {
    private String id;
    private String status;
    private String updateTime;
    private String emailAddress;
}

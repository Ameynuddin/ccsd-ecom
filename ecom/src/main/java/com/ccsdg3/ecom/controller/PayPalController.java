package com.ccsdg3.ecom.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/keys")
public class PayPalController {

    @Value("${paypal.client.id}")
    private String paypalClientId;

    @GetMapping("/paypal")
    public String getPayPalClientId() {
        return paypalClientId;
    }
}
package com.ccsdg3.ecom.controller;

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

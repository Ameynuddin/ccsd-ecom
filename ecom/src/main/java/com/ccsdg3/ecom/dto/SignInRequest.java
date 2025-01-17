package com.ccsdg3.ecom.dto;

import lombok.Data;

@Data
public class SignInRequest {
    private String email;
    private String password;
}
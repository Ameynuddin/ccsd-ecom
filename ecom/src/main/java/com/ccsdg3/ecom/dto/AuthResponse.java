package com.ccsdg3.ecom.dto;

@Data
@AllArgsConstructor
public class AuthResponse {
    private String id;
    private String name;
    private String email;
    private Boolean isAdmin;
    private String token;
}

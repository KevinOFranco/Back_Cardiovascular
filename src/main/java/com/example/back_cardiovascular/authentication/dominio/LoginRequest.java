package com.example.back_cardiovascular.authentication.dominio;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}

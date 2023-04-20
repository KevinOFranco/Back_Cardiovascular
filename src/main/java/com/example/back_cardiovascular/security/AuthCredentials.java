package com.example.back_cardiovascular.security;

import lombok.Data;

@Data
public class AuthCredentials {
    private String email;
    private String password;
}

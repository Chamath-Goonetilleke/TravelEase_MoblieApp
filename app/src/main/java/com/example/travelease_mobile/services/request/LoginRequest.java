package com.example.travelease_mobile.services.request;

public class LoginRequest {

    private String Email;
    private String Password;

    public LoginRequest(String email, String password) {
        Email = email;
        Password = password;
    }
}

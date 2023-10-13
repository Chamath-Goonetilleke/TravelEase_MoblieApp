/*
------------------------------------------------------------------------------
 File: LoginRequest.java
 Purpose: This file contains the LoginRequest class, which represents the request for a traveler's login in the TravelEase_Mobile project.
 Author: IT20122096
 Date: 2023-10-13
------------------------------------------------------------------------------
*/
package com.example.travelease_mobile.services.request;

public class LoginRequest {

    private String Email;
    private String Password;

    public LoginRequest(String email, String password) {
        Email = email;
        Password = password;
    }
}

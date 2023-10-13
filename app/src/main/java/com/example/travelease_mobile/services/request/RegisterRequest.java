/*
------------------------------------------------------------------------------
 File: RegisterRequest.java
 Purpose: This file contains the RegisterRequest class, which represents the request for registering a traveler in the TravelEase_Mobile project.
 Author: IT20122096
 Date: 2023-10-13
------------------------------------------------------------------------------
*/
package com.example.travelease_mobile.services.request;

public class RegisterRequest {
    private String nic;
    private String role;
    private String title;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String city;
    private String password;

    public RegisterRequest(String nic, String title, String firstName, String lastName, String email, String phoneNumber, String city, String password) {
        this.nic = nic;
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.password = password;
        this.role = "Traveler";
    }
}

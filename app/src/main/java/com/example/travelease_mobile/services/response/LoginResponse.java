/*
------------------------------------------------------------------------------
 File: LoginResponse.java
 Purpose: This file contains the LoginResponse class, which represents the response for a traveler's login in the TravelEase_Mobile project.
 Author: IT20122096
 Date: 2023-10-13
------------------------------------------------------------------------------
*/
package com.example.travelease_mobile.services.response;

public class LoginResponse {
    private String nic;
    private String title;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String city;
    private Integer state;
    private String imageUrl;
    private String token;

    public String getNic() {
        return nic;
    }

    public String getTitle() {
        return title;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public Integer getState() {
        return state;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getToken() {
        return token;
    }
}

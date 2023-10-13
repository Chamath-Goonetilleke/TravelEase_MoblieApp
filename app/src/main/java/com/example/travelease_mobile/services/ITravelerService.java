/**
 * ----------------------------------------------------------------------------
 * File: ITravelerService.java
 * Purpose: This interface defines the services for handling traveler-related operations in the TravelEase_Mobile project.
 * Author: IT20122096
 * Date: 2023-10-13
 * ----------------------------------------------------------------------------
 */
package com.example.travelease_mobile.services;

import com.example.travelease_mobile.services.request.LoginRequest;
import com.example.travelease_mobile.services.request.RegisterRequest;
import com.example.travelease_mobile.services.response.LoginResponse;
import com.example.travelease_mobile.services.response.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ITravelerService {

    @POST("traveler/auth")
    Call<LoginResponse> login(@Body LoginRequest loginRequest);

    @POST("traveler/register")
    Call<RegisterResponse> register(@Body RegisterRequest registerRequest);

}

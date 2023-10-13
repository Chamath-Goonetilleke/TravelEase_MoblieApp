/**
 * ----------------------------------------------------------------------------
 * File: IReservationService.java
 * Purpose: This interface defines the services for handling reservations in the TravelEase_Mobile project.
 * Author: IT20122096
 * Date: 2023-10-13
 * ----------------------------------------------------------------------------
 */
package com.example.travelease_mobile.services;

import com.example.travelease_mobile.dto.ReservationDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface IReservationService {
    @GET("reservation/reservationByTraveler/{nic}")
    Call<List<ReservationDTO>> getAllReservation(@Path("nic") String nic, @Header("Authorization") String authorization);

    @GET("reservation/reservationHistory/{nic}")
    Call<List<ReservationDTO>> getReservationHistory(@Path("nic") String nic);

}

package com.example.travelease_mobile.managers;

import com.example.travelease_mobile.dto.ReservationDTO;
import com.example.travelease_mobile.entities.CurrentUser;
import com.example.travelease_mobile.services.IReservationService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReservationManager {

    private static ReservationManager singleton;

    private CurrentUser currentUser;
    private IReservationService reservationService;

    public static ReservationManager getInstance(){
        if(singleton == null){
            singleton = new ReservationManager();
        }
        return singleton;
    }

    public ReservationManager() {
        reservationService = NetworkManager.getInstance().createService(IReservationService.class);
        currentUser = CurrentUser.getInstance();
    }

    public List<ReservationDTO> getAllReservations(String nic, String token){
        if (!NetworkManager.getInstance().isNetworkAvailable()) {
            return null;
        }
        List<ReservationDTO> reservationDTOList = new ArrayList<>();
        reservationService.getAllReservation(nic, token).enqueue(new Callback<List<ReservationDTO>>() {
            @Override
            public void onResponse(Call<List<ReservationDTO>> call, Response<List<ReservationDTO>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    reservationDTOList.addAll(response.body());
                    System.out.println("Success");
                }else {
                    if (response.errorBody() != null) {
                        try {
                            String errorResponse = response.errorBody().string();
                            System.out.println(errorResponse);
                        } catch (IOException e) {
                            e.printStackTrace();

                            System.out.println("Failed to parse error response");
                        }
                    } else {

                        System.out.println("Something Went Wrong");

                    }
                }

            }

            @Override
            public void onFailure(Call<List<ReservationDTO>> call, Throwable t) {
                System.out.println("failed");

            }
        });
        return reservationDTOList;
    }

    public List<ReservationDTO> getReservationHistory(String nic){
        if (!NetworkManager.getInstance().isNetworkAvailable()) {
            return null;
        }
        List<ReservationDTO> reservationDTOList = new ArrayList<>();
        reservationService.getReservationHistory(nic).enqueue(new Callback<List<ReservationDTO>>() {
            @Override
            public void onResponse(Call<List<ReservationDTO>> call, Response<List<ReservationDTO>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    reservationDTOList.addAll(response.body());
                    System.out.println("Success");
                }else {
                    if (response.errorBody() != null) {
                        try {
                            String errorResponse = response.errorBody().string();
                            System.out.println(errorResponse);
                        } catch (IOException e) {
                            e.printStackTrace();

                            System.out.println("Failed to parse error response");
                        }
                    } else {

                        System.out.println("Something Went Wrong");

                    }
                }

            }

            @Override
            public void onFailure(Call<List<ReservationDTO>> call, Throwable t) {
                System.out.println("failed");

            }
        });
        return reservationDTOList;
    }


}

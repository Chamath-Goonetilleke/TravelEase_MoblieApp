package com.example.travelease_mobile.managers;

import android.util.Log;

import com.example.travelease_mobile.entities.CurrentUser;
import com.example.travelease_mobile.services.ITravelerService;
import com.example.travelease_mobile.services.request.LoginRequest;
import com.example.travelease_mobile.services.request.RegisterRequest;
import com.example.travelease_mobile.services.response.LoginResponse;
import com.example.travelease_mobile.services.response.RegisterResponse;

import java.io.IOException;
import java.util.function.Consumer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TravelerManager {

    private static TravelerManager singleton;
//    private DatabaseManager databaseManager;
    private ITravelerService travelerService;

    private final CurrentUser currentUser;

    public static TravelerManager getInstance(){
        if(singleton ==null){
            singleton = new TravelerManager();
        }
        return singleton;
    }

    private TravelerManager(){
        travelerService = NetworkManager.getInstance().createService(ITravelerService.class);
        currentUser = CurrentUser.getInstance();
        //databaseManager = DatabaseManager.getInstance();
    }

    public void login(String email, String password, Runnable onSuccess, Consumer<String> onError){
        if (!NetworkManager.getInstance().isNetworkAvailable()) {
            onError.accept("No internet connectivity");
            return;
        }
        LoginRequest body = new LoginRequest(email,password);
        travelerService.login(body).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful() && response.body() != null) {

                    currentUser.MapResponse(response.body());
                    onSuccess.run();

                } else {
                    onError.accept("Incorrect Credentials");
                }

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Log.e("LOGIN_ERR:", t.toString());
                onError.accept("Unknown error occurred when trying to log in");
            }
        });
    }

    public void register(RegisterRequest body,Runnable onSuccess, Consumer<String> onError){
        if (!NetworkManager.getInstance().isNetworkAvailable()) {
            onError.accept("No internet connectivity");
            return;
        }
        travelerService.register(body).enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                System.out.println("Response:"+response.body());
                System.out.println("Response Code: " + response.code());
                if (response.isSuccessful() && response.body() != null) {
                    onSuccess.run();
                }else {
                    if (response.errorBody() != null) {
                        try {
                            String errorResponse = response.errorBody().string();
                            // Parse the error response or display it directly
                            onError.accept(errorResponse);
                        } catch (IOException e) {
                            e.printStackTrace();
                            onError.accept("Failed to parse error response");
                        }
                    } else {
                        onError.accept("Something Went Wrong");
                    }
                }

            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                onError.accept("Unknown error occurred when trying to log in");
            }
        });
    }

}
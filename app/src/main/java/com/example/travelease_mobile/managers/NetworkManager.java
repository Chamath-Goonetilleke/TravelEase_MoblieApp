/*
------------------------------------------------------------------------------
 File: NetworkManager.java
 Purpose: This file contains the NetworkManager class, which manages network-related tasks in the TravelEase_Mobile project.
 Author: IT20122096
 Date: 2023-10-13
------------------------------------------------------------------------------
*/
package com.example.travelease_mobile.managers;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkManager {
    private static NetworkManager singleton;

    private Retrofit retrofit;
    private final String baseUrl = "http://10.0.2.2:5065/api/v1/";
    private ConnectivityManager connectivityManager;

    public static NetworkManager getInstance(){
        if (singleton == null)
            singleton = new NetworkManager();
        return singleton;
    }

    private NetworkManager(){
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public <T> T createService(Class<T> serviceClass)
    {
        return retrofit.create(serviceClass);
    }

    //Check whether the device is connected to internet or not
    public boolean isNetworkAvailable(){
        Context context = ContextManager.getInstance().getApplicationContext();

        if (connectivityManager == null) {
            connectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
        }

        NetworkInfo info = connectivityManager.getActiveNetworkInfo();
        boolean available = info != null && info.isConnectedOrConnecting();

        if (!available){
            Toast.makeText(context, "Please connect to the internet and retry", Toast.LENGTH_LONG).show();
        }

        return available;
    }


}

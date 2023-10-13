/*
------------------------------------------------------------------------------
 File: ReservationFragment.java
 Purpose: This file contains the ReservationFragment class, which is responsible for
 displaying a list of reservations in the TravelEase_Mobile project.
 Author: IT20122096
 Date: 2023-10-13
------------------------------------------------------------------------------
*/
package com.example.travelease_mobile.fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.travelease_mobile.MainActivity;
import com.example.travelease_mobile.R;
import com.example.travelease_mobile.adapters.ReservationAdapter;
import com.example.travelease_mobile.dto.ReservationDTO;
import com.example.travelease_mobile.entities.CurrentUser;
import com.example.travelease_mobile.managers.ContextManager;
import com.example.travelease_mobile.managers.ReservationManager;

import java.util.ArrayList;
import java.util.List;


public class ReservationFragment extends Fragment {

    View view;
    CurrentUser currentUser;
    RecyclerView reservationRecycle;

    private Context context;

    public Context getContext() {
        return context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        currentUser = CurrentUser.getInstance();
        view = inflater.inflate(R.layout.fragment_reservation, container, false);
        context = getActivity();


        reservationRecycle = view.findViewById(R.id.reservation_recycle);
        reservationRecycle.setLayoutManager(new LinearLayoutManager(context));

        List<ReservationDTO> reservationDTOS = currentUser.getReservationList();

        System.out.println("Reservations"+currentUser.getReservationList());

        ReservationAdapter reservationAdapter = new ReservationAdapter(reservationDTOS, context);
        reservationRecycle.setAdapter(reservationAdapter);
        return view;
    }


}
package com.example.travelease_mobile.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.travelease_mobile.R;
import com.example.travelease_mobile.adapters.HistoryAdapter;
import com.example.travelease_mobile.dto.ReservationDTO;
import com.example.travelease_mobile.entities.CurrentUser;

import java.util.ArrayList;
import java.util.List;


public class HistoryFragment extends Fragment {

    View view;
    private CurrentUser currentUser;
    RecyclerView historyRecycle;
    private Context context;
    public Context getContext() {
        return context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        view = inflater.inflate(R.layout.fragment_history, container, false);
        currentUser = CurrentUser.getInstance();
        context = getActivity();
        historyRecycle= view.findViewById(R.id.history_recycle);
        historyRecycle.setLayoutManager(new LinearLayoutManager(context));

        List<ReservationDTO> reservationDTOS = currentUser.getReservationHistory();

        HistoryAdapter historyAdapter = new HistoryAdapter(reservationDTOS, context);
        historyRecycle.setAdapter(historyAdapter);

        return view;
    }
}
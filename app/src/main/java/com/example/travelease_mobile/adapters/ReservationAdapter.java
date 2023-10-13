/*
------------------------------------------------------------------------------
 File: ReservationAdapter.java
 Purpose: This file contains the ReservationAdapter class, which is responsible for
 handling reservations in the TravelEase_Mobile project.
 Author: IT20122096
 Date: 2023-10-13
------------------------------------------------------------------------------
*/
package com.example.travelease_mobile.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.travelease_mobile.R;
import com.example.travelease_mobile.dto.ReservationDTO;

import java.util.List;

public class ReservationAdapter extends RecyclerView.Adapter<ReservationAdapter.ReservationViewHolder> {

    List<ReservationDTO> reservationList;
    Context context;


    public ReservationAdapter(List<ReservationDTO> reservationList, Context context) {
        this.reservationList = reservationList;
        this.context = context;
    }

    @NonNull
    @Override
    public ReservationAdapter.ReservationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //------------------------------------------------------------------------------
        // Method: onCreateViewHolder
        // Purpose: Creates a new ViewHolder for a reservation item view.
        //------------------------------------------------------------------------------
        View view = LayoutInflater.from(context).inflate(R.layout.reservation_item, parent, false);
        return new ReservationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReservationAdapter.ReservationViewHolder holder, int position) {
        //------------------------------------------------------------------------------
        // Method: onBindViewHolder
        // Purpose: Binds data to the RecyclerView item.
        //------------------------------------------------------------------------------
        ReservationDTO reservation = reservationList.get(position);
        holder.trip.setText(reservation.getFrom() + " to " + reservation.getTo());
        holder.date.setText(reservation.getDate());
        holder.departs.setText(reservation.getTime().split(" ")[0]);
        holder.arrives.setText(reservation.getTime().split(" ")[2]);
    }

    @Override
    public int getItemCount() {
        //------------------------------------------------------------------------------
        // Method: getItemCount
        // Purpose: Returns the number of items in the RecyclerView.
        //------------------------------------------------------------------------------
        return reservationList.size();
    }

    public class ReservationViewHolder extends RecyclerView.ViewHolder {

        TextView trip, date, departs, arrives;

        public ReservationViewHolder(@NonNull View itemView) {
            super(itemView);

            trip = itemView.findViewById(R.id.trip_text);
            date = itemView.findViewById(R.id.departureDate);
            departs = itemView.findViewById(R.id.departs);
            arrives = itemView.findViewById(R.id.arrives);

        }
    }

}

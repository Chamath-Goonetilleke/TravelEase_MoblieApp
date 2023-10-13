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

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ReservationHistoryViewHolder> {

    List<ReservationDTO> reservationList;
    Context context;

    public HistoryAdapter(List<ReservationDTO> reservationList, Context context) {
        this.reservationList = reservationList;
        this.context = context;
    }

    @NonNull
    @Override
    public ReservationHistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.history_item,parent,false);
        return new ReservationHistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReservationHistoryViewHolder holder, int position) {
        ReservationDTO reservation = reservationList.get(position);
        holder.trip.setText(reservation.getFrom() + " to " + reservation.getTo());
        holder.date.setText(reservation.getDate());
        holder.departs.setText(reservation.getTime().split(" ")[0]);
        holder.arrives.setText(reservation.getTime().split(" ")[2]);
    }

    @Override
    public int getItemCount() {
        return reservationList.size();
    }

    public class ReservationHistoryViewHolder extends RecyclerView.ViewHolder {

        TextView trip, date, departs, arrives;

        public ReservationHistoryViewHolder(@NonNull View itemView) {
            super(itemView);

            trip = itemView.findViewById(R.id.trip_text_history);
            date = itemView.findViewById(R.id.departureDateHistory);
            departs = itemView.findViewById(R.id.departsHistory);
            arrives = itemView.findViewById(R.id.arrivesHistory);

        }
    }

}

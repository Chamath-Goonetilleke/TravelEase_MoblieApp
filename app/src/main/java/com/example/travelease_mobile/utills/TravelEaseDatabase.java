package com.example.travelease_mobile.utills;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.travelease_mobile.dao.TravelerDao;
import com.example.travelease_mobile.entities.Traveler;

@Database(entities = {Traveler.class}, version = 1)
public abstract class TravelEaseDatabase extends RoomDatabase {
    public abstract TravelerDao travelerDao();
}

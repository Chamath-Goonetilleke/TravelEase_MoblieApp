/*
------------------------------------------------------------------------------
 File: DatabaseManager.java
 Purpose: This file contains the DatabaseManager class, which manages the database for the TravelEase_Mobile project.
 Author: IT20122096
 Date: 2023-10-13
------------------------------------------------------------------------------
*/
package com.example.travelease_mobile.managers;

import androidx.room.Room;

import com.example.travelease_mobile.utills.TravelEaseDatabase;

public class DatabaseManager {
    private static DatabaseManager singleton;
    private final String databaseName = "travelEase";
    private ContextManager contextManager;
    private TravelEaseDatabase database;

    public static DatabaseManager getInstance(){
        if (singleton == null)
            singleton = new DatabaseManager();
        return singleton;
    }
    private DatabaseManager(){
        contextManager = ContextManager.getInstance();
        database = Room.databaseBuilder(
                contextManager.getApplicationContext(),
                TravelEaseDatabase.class,
                databaseName).build();
    }
    public TravelEaseDatabase database(){
        return database;
    }
}

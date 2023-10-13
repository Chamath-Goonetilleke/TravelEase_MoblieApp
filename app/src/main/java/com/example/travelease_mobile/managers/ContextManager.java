/*
------------------------------------------------------------------------------
 File: ContextManager.java
 Purpose: This file contains the ContextManager class, which manages the application context in the TravelEase_Mobile project.
 Author: IT20122096
 Date: 2023-10-13
------------------------------------------------------------------------------
*/
package com.example.travelease_mobile.managers;

import android.content.Context;

public class ContextManager {
    private static ContextManager singleton;
    private Context applicationContext;

    public static ContextManager getInstance() {
        if (singleton == null)
            singleton = new ContextManager();
        return singleton;
    }

    public void setApplicationContext(Context applicationContext){
        this.applicationContext = applicationContext;
    }

    public Context getApplicationContext(){
        return applicationContext;
    }
}


/*
------------------------------------------------------------------------------
 File: HomeFragment.java
 Purpose: This file contains the HomeFragment class, which is responsible for
 displaying an image slider on the home screen in the TravelEase_Mobile project.
 Author: IT20122096
 Date: 2023-10-13
------------------------------------------------------------------------------
*/
package com.example.travelease_mobile.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.travelease_mobile.R;
import com.example.travelease_mobile.adapters.ImageSliderAdapter;


public class HomeFragment extends Fragment {


    ViewPager viewPager;
    View view;
    ImageSliderAdapter adapter;

    Context context;

    private int currentPage = 0;
    private static final long AUTO_SLIDE_DELAY = 2000; // Adjust the delay as needed
    private Handler autoSlideHandler;
    int[] imageResources = {
            R.drawable.train, R.drawable.train2, R.drawable.train3
    };
    public Context getContext() {
        return context;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);

        context = getActivity();
        viewPager = view.findViewById(R.id.viewPager);
        adapter = new ImageSliderAdapter(context,imageResources);
        viewPager.setAdapter(adapter);
        autoSlideHandler = new Handler(Looper.getMainLooper());
        startAutoSlide();
        return view;
    }
    private void startAutoSlide() {
        autoSlideHandler.postDelayed(autoSlideRunnable, AUTO_SLIDE_DELAY);
    }

    private Runnable autoSlideRunnable = new Runnable() {
        @Override
        public void run() {
            if (currentPage == imageResources.length) {
                currentPage = 0;
            }
            viewPager.setCurrentItem(currentPage, true);
            currentPage++;
            startAutoSlide();
        }
    };}


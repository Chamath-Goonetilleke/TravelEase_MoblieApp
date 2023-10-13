/*
------------------------------------------------------------------------------
 File: ImageSliderAdapter.java
 Purpose: This file contains the ImageSliderAdapter class, which is responsible for
 handling the image slider in the TravelEase_Mobile project.
 Author: IT20122096
 Date: 2023-10-13
------------------------------------------------------------------------------
*/
package com.example.travelease_mobile.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.viewpager.widget.PagerAdapter;

import com.example.travelease_mobile.R;

public class ImageSliderAdapter extends PagerAdapter {

    private Context context;
    private int[] images;

    public ImageSliderAdapter(Context context, int[] images) {
        this.context = context;
        this.images = images;
    }

    @Override
    public int getCount() {
        //------------------------------------------------------------------------------
        // Method: getCount
        // Purpose: Returns the total number of images in the slider.
        //------------------------------------------------------------------------------
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        //------------------------------------------------------------------------------
        // Method: isViewFromObject
        // Purpose: Checks if a view is associated with a specific object.
        //------------------------------------------------------------------------------
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        //------------------------------------------------------------------------------
        // Method: instantiateItem
        // Purpose: Creates a new item in the image slider.
        //------------------------------------------------------------------------------
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.slider_item, container, false);

        // Load the image into the ImageView using Picasso
        ((ImageView) itemView.findViewById(R.id.sliderImageView)).setImageResource(images[position]);


        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //------------------------------------------------------------------------------
        // Method: destroyItem
        // Purpose: Removes an item from the image slider.
        //------------------------------------------------------------------------------
        container.removeView((View) object);
    }
}

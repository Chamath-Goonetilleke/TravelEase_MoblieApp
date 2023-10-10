package com.example.travelease_mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.travelease_mobile.databinding.ActivityMainBinding;
import com.example.travelease_mobile.fragments.HomeFragment;
import com.example.travelease_mobile.fragments.ProfileFragment;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.bottomNavigationView.setBackground(null);
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.navigation_item1:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.navigation_item2:
                    replaceFragment(new ProfileFragment());
                    break;
                case R.id.navigation_item3:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.navigation_item4:
                    replaceFragment(new ProfileFragment());
                    break;
            }
            return true;
        });


    }
    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}
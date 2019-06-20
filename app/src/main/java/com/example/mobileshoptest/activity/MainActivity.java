package com.example.mobileshoptest.activity;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.mobileshoptest.R;
import com.example.mobileshoptest.fragment.NaviationFragment;

public class MainActivity extends AppCompatActivity {
    private NaviationFragment naviationFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        naviationFragment = new NaviationFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.add(R.id.main_frame,naviationFragment).commit();

    }
}

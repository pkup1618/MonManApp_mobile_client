package com.example.monmanapp.activities;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.example.monmanapp.R;
import com.example.monmanapp.fragments.PurchasesFragment;


public class WatchingAndDeletingActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watching_and_deleting);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.watching_and_deleting_activity_fragmentContainer);
        if (fragment == null) {
            fragment = new PurchasesFragment();
            fragmentManager.beginTransaction()
                    .add(R.id.watching_and_deleting_activity_fragmentContainer, fragment).commit();
        }
    }
}


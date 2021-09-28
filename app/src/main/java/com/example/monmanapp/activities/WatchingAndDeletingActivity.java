package com.example.monmanapp.activities;


import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.example.monmanapp.R;
import com.example.monmanapp.fragments.PurchaseFragment;
import com.example.monmanapp.fragments.PurchasesFragment;
import com.example.monmanapp.models.PurchasesContainer;


public class WatchingAndDeletingActivity extends FragmentActivity {

    private PurchasesFragment fragment;
    private Button updatePurchasesButton;
    private EditText dayText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watching_and_deleting);

        updatePurchasesButton = findViewById(R.id.watching_and_deleting_activity_update_button);
        dayText = findViewById(R.id.watching_and_deleting_activity_day_editText);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragment = (PurchasesFragment) fragmentManager.findFragmentById(R.id.watching_and_deleting_activity_fragmentContainer);
        if (fragment == null) {
            fragment = new PurchasesFragment();
            fragmentManager.beginTransaction()
                    .add(R.id.watching_and_deleting_activity_fragmentContainer, fragment).commit();
        }

        updatePurchasesButton.setOnClickListener(new updatePurchasesButtonBehaviour());

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    class updatePurchasesButtonBehaviour implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            PurchasesContainer purchasesContainer = PurchasesContainer.getInstance();
            purchasesContainer.updateListOfPurchases(dayText.getText().toString());
            fragment.updateUI();
        }
    }
}


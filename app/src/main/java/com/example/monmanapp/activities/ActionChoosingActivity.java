package com.example.monmanapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.monmanapp.R;

public class ActionChoosingActivity  extends AppCompatActivity {

    private Button settingActivityButton;
    private Button watchingAndDeletingActivityButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_choosing);

        settingActivityButton = findViewById(R.id.action_choosing_activity_setting_activity_button);
        watchingAndDeletingActivityButton = findViewById(R.id.action_choosing_activity_watching_and_deleting_activity_button);

        settingActivityButton.setOnClickListener(new SettingActivityButtonBehaviour());
        watchingAndDeletingActivityButton.setOnClickListener(new WatchingAndDeletingActivityButtonBehaviour());
    }


    class SettingActivityButtonBehaviour implements View.OnClickListener {

        @Override
        public void onClick(View view) {

            Intent simpleIntent = new Intent(ActionChoosingActivity.this, SettingActivity.class);
            startActivity(simpleIntent);
        }
    }


    class WatchingAndDeletingActivityButtonBehaviour implements View.OnClickListener {

        @Override
        public void onClick(View view) {

            Intent simpleIntent = new Intent(ActionChoosingActivity.this, WatchingAndDeletingActivity.class);
            startActivity(simpleIntent);
        }
    }
}

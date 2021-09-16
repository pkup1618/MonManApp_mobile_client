package com.example.monmanapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.monmanapp.R;

public class MainActivity extends AppCompatActivity {

    private Button letsTryButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        letsTryButton = findViewById(R.id.main_activity_try_to_use_button);
        letsTryButton.setOnClickListener(new LetsTryButtonBehaviour());

    }


    class LetsTryButtonBehaviour implements View.OnClickListener {

        @Override
        public void onClick(View view) {

            Intent simpleIntent = new Intent(MainActivity.this, ActionChoosingActivity.class);
            startActivity(simpleIntent);
        }
    }
}


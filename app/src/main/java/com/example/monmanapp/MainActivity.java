package com.example.monmanapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //TODO прикрутить действие для кнопки (вызвать вторую активность)
    //TODO сделать крутилку с объяснениями


    private Button letsTryButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("CREATED");

        letsTryButton = findViewById(R.id.try_to_use_button);
        letsTryButton.setOnClickListener(new LetsTryButtonBehaviour());

    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("STARTED");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("RESUMED");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("PAUSED");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("STOPPED");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("RESTARTED");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("DESTROYED");
    }

    class LetsTryButtonBehaviour implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Intent simpleIntent = new Intent(MainActivity.this, EditingActivity.class);
            startActivity(simpleIntent);
        }
    }
}


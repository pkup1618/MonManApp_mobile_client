package com.example.monmanapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button mSendRequestButton;
    Button mSetCalendarDateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSendRequestButton = (Button) findViewById(R.id.send_request_button);
        mSetCalendarDateButton = (Button) findViewById(R.id.set_calendar_day_button);

        View any_view = findViewById(R.id.set_calendar_day_button);



        mSendRequestButton.setOnClickListener(new RequestButtonOnClick());
        mSetCalendarDateButton.setOnClickListener(new DateCalendarButtonOnClick());
    }
}

class RequestButtonOnClick implements View.OnClickListener {

    @Override
    public void onClick(View view) {
        Toast toast = Toast.makeText(view.getContext(), R.string.send_status, Toast.LENGTH_LONG);
        toast.show();
    }
}

class DateCalendarButtonOnClick implements View.OnClickListener {
    @Override
    public void onClick(View view) {
        Toast toast = Toast.makeText(view.getContext(), R.string.date_is_set, Toast.LENGTH_LONG);
        toast.show();
    }
}


package com.example.monmanapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.monmanapp.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Активность для внесения элементов в базу данных
 */
public class SettingActivity extends AppCompatActivity {

    private final String SET_EARNING_URL = "http://192.168.0.106:8080/null/set-earning";
    private final String SET_PURCHASE_URL = "http://192.168.0.106:8080/null/set-purchase";

    private URL url;
    private Switch earningsOrPurchaseSwitch;
    private EditText nameEditText;
    private EditText typeEditText;
    private EditText costEditText;
    private EditText countEditText;
    private EditText dayEditText;
    private EditText paymentTypeEditText;
    private Button setButton;


    /**
     * Что нужно сделать при инициализации активности
     * @param savedInstanceState (?) состояние чего-то
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        earningsOrPurchaseSwitch = findViewById(R.id.setting_activity_earnings_or_purchases_switch);
        nameEditText = findViewById(R.id.setting_activity_name_editText);
        typeEditText = findViewById(R.id.setting_activity_type_editText);
        costEditText = findViewById(R.id.setting_activity_cost_editText);
        countEditText = findViewById(R.id.setting_activity_count_editText);
        dayEditText = findViewById(R.id.setting_activity_day_editText);
        paymentTypeEditText = findViewById(R.id.setting_activity_payment_type_editText);
        setButton = findViewById(R.id.setting_activity_set_button);

        setButton.setOnClickListener(new EditingButtonBehaviour());

        //todo понять поглубже как это работает
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }


    /**
     * Собрать значения с заполненных полей и скомпоновать их в JSON-объект
     * @return скомпонованные значения
     */
    private JSONObject generateJsonBodyFromFieldValues() {

        JSONObject jsonObject = new JSONObject();

        try {
            if (earningsOrPurchaseSwitch.isChecked()) {
                jsonObject.put("purchase_name", nameEditText.getText());
                jsonObject.put("purchase_type", typeEditText.getText());
                jsonObject.put("purchase_cost", Double.valueOf(String.valueOf(costEditText.getText())));
            }
            else {
                jsonObject.put("earning_name", nameEditText.getText());
                jsonObject.put("earning_type", typeEditText.getText());
                jsonObject.put("earning_cost", Double.valueOf(String.valueOf(costEditText.getText())));
            }
            jsonObject.put("count", Integer.valueOf(String.valueOf(countEditText.getText())));
            jsonObject.put("day", dayEditText.getText());
            jsonObject.put("payment_type", paymentTypeEditText.getText());
        }
        catch (JSONException e) {
            //todo а как нормально?
            e.printStackTrace();
        }

        return jsonObject;
    }


    /**
     * Установить url, к которому обращаться
     */
    private void setUrl() {

        try {
            if (earningsOrPurchaseSwitch.isChecked()) {
                url = new URL(SET_PURCHASE_URL);
            }
            else {
                url = new URL(SET_EARNING_URL);
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Локальный класс для реализации работы с сетью по нажатию на кнопку
     */
    class EditingButtonBehaviour implements View.OnClickListener {

        @Override
        public void onClick(View view) {


            HttpURLConnection httpURLConnection;
            String body;

            try {
                body = generateJsonBodyFromFieldValues().toString();
                setUrl();

                httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestProperty("Content-Type", "application/json");
                httpURLConnection.setReadTimeout(10000);
                httpURLConnection.setConnectTimeout(15000);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);

                httpURLConnection.connect();

                OutputStreamWriter os = new OutputStreamWriter(httpURLConnection.getOutputStream());
                os.write(body);
                os.close();

                //todo почему не работает без этого? (ниже)
                int i = httpURLConnection.getResponseCode();
                Toast.makeText(SettingActivity.this, "done", Toast.LENGTH_LONG).show();
            }
            catch(IOException e) {
                e.printStackTrace();
                Toast.makeText(SettingActivity.this, "something wrong", Toast.LENGTH_LONG).show();
            }
        }
    }
}
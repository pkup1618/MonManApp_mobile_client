package com.example.monmanapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.monmanapp.R;
import com.example.monmanapp.models.Purchase;


public class PurchaseFragment extends Fragment {

    private Purchase purchase;
    private TextView nameText;
    private TextView typeText;
    private TextView costText;
    private TextView countText;
    private TextView dayText;
    private Button deleteButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        purchase = new Purchase();
    }


    // Так можно в коде прописать установку конкретного шаблона
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_purchase, container, false);

        nameText = view.findViewById(R.id.purchase_fragment_purchase_name);
        typeText = view.findViewById(R.id.purchase_fragment_purchase_type);
        costText = view.findViewById(R.id.purchase_fragment_purchase_cost);
        countText = view.findViewById(R.id.purchase_fragment_purchase_count);
        dayText = view.findViewById(R.id.purchase_fragment_purchase_day);
        deleteButton = view.findViewById(R.id.purchase_fragment_delete_button);


        return view;
    }
}

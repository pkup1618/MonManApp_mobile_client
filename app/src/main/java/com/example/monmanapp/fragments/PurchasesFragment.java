package com.example.monmanapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.monmanapp.R;
import com.example.monmanapp.models.PurchasesContainer;
import com.example.monmanapp.models.Purchase;
import com.example.monmanapp.web_layer.ServerConnectivity;

import java.util.List;

public class PurchasesFragment extends Fragment {

    private RecyclerView purchasesRecyclerView;
    private PurchaseAdapter purchaseAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_purchases, container, false);

        purchasesRecyclerView = (RecyclerView) view.findViewById(R.id.purchases_fragment_recycler_view);
        purchasesRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    public void updateUI() {

        PurchasesContainer purchasesContainer = PurchasesContainer.getInstance();
        List<Purchase> purchases = purchasesContainer.getListOfRecords();

        purchaseAdapter = new PurchaseAdapter(purchases);
        purchasesRecyclerView.setAdapter(purchaseAdapter);
    }

    private class PurchaseHolder extends RecyclerView.ViewHolder {

        private TextView nameText;
        private TextView typeText;
        private TextView costText;
        private TextView countText;
        private TextView dayText;
        private TextView paymentTypeText;
        private Integer dbId;
        private Button button;

        public PurchaseHolder(View view) {
            super(view);

            nameText = (TextView) view.findViewById(R.id.purchase_fragment_purchase_name);
            typeText = (TextView) view.findViewById(R.id.purchase_fragment_purchase_type);
            costText = (TextView) view.findViewById(R.id.purchase_fragment_purchase_cost);
            countText = (TextView) view.findViewById(R.id.purchase_fragment_purchase_count);
            dayText = (TextView) view.findViewById(R.id.purchase_fragment_purchase_day);
            paymentTypeText = (TextView) view.findViewById(R.id.purchase_fragment_payment_type);
            button = (Button) view.findViewById(R.id.purchase_fragment_delete_button);
            button.setOnClickListener(new deletePurchaseButtonBehaviour());

        }
        class deletePurchaseButtonBehaviour implements View.OnClickListener {

            @Override
            public void onClick(View view) {
                ServerConnectivity serverConnectivity = ServerConnectivity.getInstance();
                serverConnectivity.makeJsonRequest(serverConnectivity.generateJsonFromId(dbId), ServerConnectivity.DELETE_PURCHASE_URL);
                Toast.makeText(getContext(), "удалён " + dbId.toString(), Toast.LENGTH_LONG);
            }
        }
    }

    private class PurchaseAdapter extends RecyclerView.Adapter<PurchaseHolder> {

        private List<Purchase> purchases;

        public PurchaseAdapter(List<Purchase> purchases) {
            this.purchases = purchases;
        }

        @NonNull
        @Override
        public PurchaseHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.fragment_purchase, parent, false);
            return new PurchaseHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull PurchaseHolder holder, int position) {
            Purchase purchase = purchases.get(position);
            holder.nameText.setText(purchase.getPurchaseName());
            holder.typeText.setText(purchase.getPurchaseType());
            holder.costText.setText(purchase.getPurchaseCost());
            holder.countText.setText(purchase.getCount());
            holder.dayText.setText(purchase.getDay());
            holder.paymentTypeText.setText(purchase.getPaymentType());
            holder.dbId = purchase.getDbId();

        }

        @Override
        public int getItemCount() {
            return purchases.size();
        }
    }
}

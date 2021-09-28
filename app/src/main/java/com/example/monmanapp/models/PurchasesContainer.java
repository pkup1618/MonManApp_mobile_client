package com.example.monmanapp.models;

import com.example.monmanapp.web_layer.ServerConnectivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//Singleton
public class PurchasesContainer {


    /*
    Фактически, это оперативная память приложения.
    Она не существует при выключении, а заполняется только при первой инстанцииации

    Пусть он будет обращаться к классу сетевого взаимодействия для обновления своих данных
     */

    private static PurchasesContainer instance;
    public static PurchasesContainer getInstance() {
        if (instance == null) {
            instance = new PurchasesContainer();
        }
        return instance;
    }
    private PurchasesContainer() {

        listOfPurchases = new ArrayList<Purchase>();
    }


    private List<Purchase> listOfPurchases;
    public List<Purchase> getListOfRecords() {
        return listOfPurchases;
    }


    public Purchase getPurchase(UUID id) {
        for(Purchase purchase : listOfPurchases) {
            if (purchase.getId().equals(id)){
                return purchase;
            }
        }
        return null;
    }


    public void updateListOfPurchases(String date) {

        List<Purchase> buffer = new ArrayList<Purchase>();
        ServerConnectivity serverConnectivity = ServerConnectivity.getInstance();
        JSONArray jsonArrayPurchases = serverConnectivity.makeJsonRequest(
                        serverConnectivity.generateJsonFromDate(date),
                        ServerConnectivity.GET_DAY_PURCHASES_URL);

        JSONObject jsonObject;
        for (int i = 0; true; i++) {
            try {
                jsonObject = jsonArrayPurchases.getJSONObject(i);
                Purchase purchase = new Purchase();

                purchase.setPurchaseName(jsonObject.getString("purchase_name"));
                purchase.setPurchaseType(jsonObject.getString("purchase_type"));
                purchase.setPurchaseCost(jsonObject.getString("purchase_cost"));
                purchase.setCount(jsonObject.getString("count"));
                purchase.setDay(jsonObject.getString("day"));
                purchase.setPaymentType(jsonObject.getString("payment_type"));
                purchase.setDbId(jsonObject.getInt("id"));

                buffer.add(purchase);
            }
            catch (JSONException e) {
                break;
            }
        }
        listOfPurchases = buffer;
    }
}

package com.example.monmanapp.models;

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

        //text objects

        for (Integer i = 0; i < 20; i++) {
            Purchase purchase = new Purchase();
            purchase.setName(i.toString());
            purchase.setType(i.toString());
            purchase.setCost(i.toString());
            purchase.setCount(i.toString());
            purchase.setDay(i.toString());
            purchase.setDbId(i);
            listOfPurchases.add(purchase);
        }
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

}

package com.example.monmanapp.models;

import java.util.UUID;

public class Purchase {

    private UUID id;
    public UUID getId() {
        return id;
    }


    //Все строковые, потому что фактически нужны только для вывода на экран

    String name;
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    String type;
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    String cost;
    public String getCost() { return cost; }
    public void setCost(String cost) { this.cost = cost; }

    String count;
    public String getCount() { return count; }
    public void setCount(String count) { this.count = count; }

    String day;
    public String getDay() { return day; }
    public void setDay(String day) { this.day = day; }

    Integer dbId;
    public Integer getDbId() { return dbId; }
    public void setDbId(Integer dbId) { this.dbId = dbId; }


    public Purchase() {
        id = UUID.randomUUID();
    }
}

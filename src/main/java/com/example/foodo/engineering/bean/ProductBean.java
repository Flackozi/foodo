package com.example.foodo.engineering.bean;

public class ProductBean {
    private String Name;
    private String Quantity;
    private String TypeOfFood;
    private String Expiration;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getTypeOfFood() {
        return TypeOfFood;
    }

    public void setTypeOfFood(String typeOfFood) {
        TypeOfFood = typeOfFood;
    }

    public String getExpiration() {
        return Expiration;
    }

    public void setExpiration(String expiration) {
        Expiration = expiration;
    }

}

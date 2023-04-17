package com.example.foodo.model;

public class Product {
    private String Name;
    private String Quantity;
    private String TypeOfFood;
    private String Expiration;


    public Product(String name, String quantity, String expiration, String typeOfFood) {
        this.Name = name;
        this.Quantity = quantity;
        this.TypeOfFood = typeOfFood;
        this.Expiration = expiration;
    }

    public String getName() {
        return Name;
    }

    public String getQuantity() {
        return Quantity;
    }

    public String getTypeOfFood() {
        return TypeOfFood;
    }

    public String getExpiration() {
        return Expiration;
    }
}

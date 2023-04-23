package com.example.foodo.model;

import java.util.Date;

public class Product {
    private String Name;
    private int Quantity;
    private String TypeOfFood;
    private Date Expiration;


    public Product(String name, int quantity, Date expiration, String typeOfFood) {
        this.Name = name;
        this.Quantity = quantity;
        this.TypeOfFood = typeOfFood;
        this.Expiration = expiration;
    }

    public String getName() {
        return Name;
    }

    public int getQuantity() {
        return Quantity;
    }

    public String getTypeOfFood() {
        return TypeOfFood;
    }

    public java.sql.Date getExpiration() {
        return (java.sql.Date) Expiration;
    }
}

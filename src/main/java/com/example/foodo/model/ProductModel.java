package com.example.foodo.model;

public class ProductModel {
    private String Name;
    private int Quantity;
    private String TypeOfFood;
    private int expirationDay;
    private int expirationMonth;
    private  int expirationYear;
    private String Expiration;

    public void setName(String name) {
        Name = name;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
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


    public ProductModel(){}

    public ProductModel(String name, int quantity, String typeOfFood, int expirationDay, int expirationMonth, int expirationYear) {
        this.Name = name;
        this.Quantity = quantity;
        this.TypeOfFood = typeOfFood;
        this.expirationDay=expirationDay;
        this.expirationMonth=expirationMonth;
        this.expirationYear=expirationYear;
    }
    public ProductModel(String name, int quantity, String typeOfFood, String expiration) {
        this.Name = name;
        this.Quantity = quantity;
        this.TypeOfFood = typeOfFood;
        this.Expiration=expiration;
    }

    public ProductModel(String Name){
        this.Name=Name;
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
    public int getExpirationDay() {
        return expirationDay;
    }

    public void setExpirationDay(int expirationDay) {
        this.expirationDay = expirationDay;
    }

    public int getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(int expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public int getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(int expirationYear) {
        this.expirationYear = expirationYear;
    }

}

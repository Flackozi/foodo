package com.example.foodo.model;

public class ProductModel {
    private String name;
    private String quantity;
    private String typeOfFood;
    private int expirationDay;
    private int expirationMonth;
    private  int expirationYear;
    private String expiration;


    public ProductModel(){}

    public ProductModel(String name, String quantity, String typeOfFood, int expirationDay, int expirationMonth, int expirationYear) {
        this.name = name;
        this.quantity = quantity;
        this.typeOfFood = typeOfFood;
        this.expirationDay=expirationDay;
        this.expirationMonth=expirationMonth;
        this.expirationYear=expirationYear;
    }
    public ProductModel(String name, String quantity, String typeOfFood, String expiration) {
        this.name = name;
        this.quantity = quantity;
        this.typeOfFood = typeOfFood;
        this.expiration =expiration;
    }

    public ProductModel(String name, String quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public ProductModel(String name){
        this.name =name;
    }
    public String getName() {
        return name;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getTypeOfFood() {
        return typeOfFood;
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
    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setTypeOfFood(String typeOfFood) {
        this.typeOfFood = typeOfFood;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

}

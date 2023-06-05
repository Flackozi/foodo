package com.example.foodo.engineering.bean;

import com.example.foodo.engineering.pattern.observer.Subject;

public class ProductBean extends Subject {
    private String Name;
    private String Squantity;
    private int Quantity;
    private String TypeOfFood;
    private int day;
    private int month;
    private int year;


    private String Expiration;

    public ProductBean(String name, int quantity, String TypeOfFood, int expirationDay, int expirationMonth, int expirationYear) {
    }
    public ProductBean(String name, int quantity, String TypeOfFood, String expiration) {
        this.setName(name);
        this.setQuantity(quantity);
        this.setTypeOfFood(TypeOfFood);
        this.setExpiration(expiration);
    }
    public ProductBean(String name, int quantity) {
        this.setName(name);
        this.setQuantity(quantity);
    }

    public ProductBean(String name, String Squantity){
        this.setName(name);
        this.setSquantity(Squantity);
    }
    public ProductBean (String name){
        this.Name=name;
    }
    public ProductBean(){}

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int squantity) {
        this.Quantity = squantity;
    }

    public String getTypeOfFood() {
        return TypeOfFood;
    }

    public void setTypeOfFood(String typeOfFood) {
        this.TypeOfFood = typeOfFood;
    }
    public String getExpiration() {
        return Expiration;
    }

    public void setExpiration(String expiration) {
        this.Expiration = expiration;
    }

    public void setSquantity(String quantity) {
        this.Squantity = quantity;
    }
    public String getSquantity() {
        return Squantity;
    }
}

package com.example.foodo.engineering.bean;

import com.example.foodo.engineering.pattern.observer.Subject;

public class ProductBean extends Subject {
    private String name;
    private String squantity;
    private int quantity;
    private String typeOfFood;
    private int day;
    private int month;
    private int year;
    private String expiration;


    public ProductBean(String name, int quantity, String typeOfFood, String expiration) {
        this.setName(name);
        this.setQuantity(quantity);
        this.setTypeOfFood(typeOfFood);
        this.setExpiration(expiration);
    }
    public ProductBean(String name, int quantity) {
        this.setName(name);
        this.setQuantity(quantity);
    }

    public ProductBean(String name, String squantity){
        this.setName(name);
        this.setSquantity(squantity);
    }
    public ProductBean (String name){
        this.name =name;
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
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int squantity) {
        this.quantity = squantity;
    }

    public String getTypeOfFood() {
        return typeOfFood;
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

    public void setSquantity(String quantity) {
        this.squantity = quantity;
    }
    public String getSquantity() {
        return squantity;
    }
}

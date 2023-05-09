package com.example.foodo.engineering.bean;

public class ProductBean {
    private String Name;
    private int Quantity;
    private String TypeOfFood;
    private int day;
    private int month;
    private int year;

    public ProductBean(String name, int quantity, String TypeOfFood, int expirationDay, int expirationMonth, int expirationYear) {
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
        Name = name;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public String getTypeOfFood() {
        return TypeOfFood;
    }

    public void setTypeOfFood(String typeOfFood) {
        TypeOfFood = typeOfFood;
    }



}

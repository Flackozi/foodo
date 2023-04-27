package com.example.foodo.model;

public class ProductModel {
    private String Name;
    private int Quantity;
    private String TypeOfFood;
    private int expirationDay;
    private int expirationMonth;
    private int expirationYear;



    public ProductModel(String name, int quantity, String typeOfFood, int expirationDay, int expirationMonth, int expirationYear) {
        this.Name = name;
        this.Quantity = quantity;
        this.TypeOfFood = typeOfFood;
        this.expirationDay=expirationDay;
        this.expirationMonth=expirationMonth;
        this.expirationYear=expirationYear;
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

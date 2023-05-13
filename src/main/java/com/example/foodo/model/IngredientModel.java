package com.example.foodo.model;

public class IngredientModel {
    private String Name;
    private String Quantity;
    public IngredientModel(String name, String quantity) {
        this.Name = name;
        this.Quantity = quantity;
    }


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
}

package com.example.foodo.engineering.bean;

public class IngredientBean {
    private String Name;
    private String Quantity;

    public IngredientBean(String name, String quantity) {
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

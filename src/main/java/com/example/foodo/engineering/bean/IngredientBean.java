package com.example.foodo.engineering.bean;

public class IngredientBean {
    private String IngredientName;
    private String IngredientQuantity;

    public IngredientBean(String name, String quantity) {
        this.IngredientName = name;
        this.IngredientQuantity = quantity;
    }



    public String getName() {
        return IngredientName;
    }

    public void setName(String name) {
        IngredientName = name;
    }

    public String getQuantity() {
        return IngredientQuantity;
    }

    public void setQuantity(String quantity) {
        IngredientQuantity = quantity;
    }
}

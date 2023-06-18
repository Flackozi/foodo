package com.example.foodo.engineering.bean;

public class IngredientBean {
    private String ingredientName;
    private String ingredientQuantity;

    public IngredientBean(String name, String quantity) {
        this.ingredientName = name;
        this.ingredientQuantity = quantity;
    }



    public String getName() {
        return ingredientName;
    }

    public void setName(String name) {
        ingredientName = name;
    }

    public String getQuantity() {
        return ingredientQuantity;
    }

    public void setQuantity(String quantity) {
        ingredientQuantity = quantity;
    }
}

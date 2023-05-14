package com.example.foodo.engineering.bean;

public class RecipeBean {
    private String RecipeName;
    private String Description;
    private String ChefName;

    public RecipeBean(){}

    public RecipeBean(String recipeName, String description, String chefName) {
        this.RecipeName = recipeName;
        this.Description = description;
        this.ChefName = chefName;
    }

    public String getRecipeName() {
        return RecipeName;
    }

    public void setRecipeName(String recipeName) {
        RecipeName = recipeName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getChefName() {
        return ChefName;
    }

    public void setChefName(String chefName) {
        ChefName = chefName;
    }
}

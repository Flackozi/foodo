package com.example.foodo.model;

import java.util.List;

public class RecipeModel {
    private String Name;
    private List<IngredientModel> Ingredients;
    private String Description;

    public void RecipeModel(String name, List<IngredientModel> ingredients, String description){
        this.setName(name);
        this.setIngredients(ingredients);
        this.setDescription(description);
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public List<IngredientModel> getIngredients() {
        return Ingredients;
    }

    public void setIngredients(List<IngredientModel> ingredients) {
        this.Ingredients = ingredients;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }


}

package com.example.foodo.model;

import java.util.List;

public class RecipeModel {
    private String RecipeName;
//    private List<IngredientModel> Ingredients;
    private String Description;
    private String ChefName;

    public RecipeModel(String name, String description, String chefName){
        this.setRecipeName(name);
//        this.setIngredients(ingredients);
        this.setDescription(description);
        this.setChefName(chefName);
    }

    public String getRecipeName() {
        return RecipeName;
    }

    public void setRecipeName(String name) {
        RecipeName = name;
    }

//    public List<IngredientModel> getIngredients() {
//        return Ingredients;
//    }
//
//    public void setIngredients(List<IngredientModel> ingredients) {
//        this.Ingredients = ingredients;
//    }

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

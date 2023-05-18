package com.example.foodo.model;

import java.io.File;

public class RecipeModel {
    private String RecipeName;
//    private List<IngredientModel> Ingredients;
    private String Description;
    private String ChefName;
    private String Path;

    public RecipeModel(){}

    public RecipeModel(String name, String description, String chefName, String path){
        this.setRecipeName(name);
//        this.setIngredients(ingredients);
        this.setDescription(description);
        this.setChefName(chefName);
        this.setPath(path);
    }

    public String getRecipeName() {
        return RecipeName;
    }

    public void setRecipeName(String name) {
        RecipeName = name;
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
    public String getPath() {
        return Path;
    }

    public void setPath(String path) {
        Path = path;
    }


}

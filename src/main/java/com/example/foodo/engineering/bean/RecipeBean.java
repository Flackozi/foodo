package com.example.foodo.engineering.bean;

import java.io.File;

public class RecipeBean {
    private String RecipeName;
    private String Description;
    private String ChefName;
    private File RecipeImage;

    public RecipeBean(){}

    public RecipeBean(String recipeName, String description, String chefName, File recipeImage) {
        this.RecipeName = recipeName;
        this.Description = description;
        this.ChefName = chefName;
        this.RecipeImage=recipeImage;
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

    public File getRecipeImage() {
        return RecipeImage;
    }

    public void setRecipeImage(File recipeImage) {
        RecipeImage = recipeImage;
    }

}

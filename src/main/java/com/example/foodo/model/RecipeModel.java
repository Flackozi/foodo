package com.example.foodo.model;

import java.io.File;

public class RecipeModel {
    private String RecipeName;
//    private List<IngredientModel> Ingredients;
    private String Description;
    private String ChefName;
    private File RecipeImage;

    public RecipeModel(String name, String description, String chefName, File recipeImage){
        this.setRecipeName(name);
//        this.setIngredients(ingredients);
        this.setDescription(description);
        this.setChefName(chefName);
        this.setRecipeImage(recipeImage);
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
    public File getRecipeImage() {
        return RecipeImage;
    }

    public void setRecipeImage(File recipeImage) {
        RecipeImage = recipeImage;
    }
}

package com.example.foodo.engineering.bean;



public class RecipeBean {
    private String RecipeName;
    private String Description;
    private String ChefName;
    private String Path;

    public RecipeBean(){}

    public RecipeBean(String recipeName, String description, String chefName, String path) {
        this.RecipeName = recipeName;
        this.Description = description;
        this.ChefName = chefName;
        this.Path=path;
    }

    public RecipeBean(String recipeName, String chefName, String path) {
        this.RecipeName = recipeName;
        this.ChefName = chefName;
        this.Path=path;
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

    public String getPath() {
        return Path;
    }

    public void setPath(String path) {
        Path = path;
    }

}

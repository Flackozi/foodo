package com.example.foodo.engineering.bean;



public class RecipeBean {
    private String recipeName;
    private String description;
    private String chefName;
    private String path;

    public RecipeBean(){}

    public RecipeBean(String recipeName, String description, String chefName, String path) {
        this.recipeName = recipeName;
        this.description = description;
        this.chefName = chefName;
        this.path =path;
    }

    public RecipeBean(String recipeName, String chefName, String path) {
        this.recipeName = recipeName;
        this.chefName = chefName;
        this.path =path;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
    public void setChefName(String chefName) {
        this.chefName = chefName;
    }
    public String getChefName() {
        return chefName;
    }
    public void setPath(String path) {
        this.path = path;
    }
    public String getPath() {
        return path;
    }



}

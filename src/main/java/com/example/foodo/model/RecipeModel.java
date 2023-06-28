package com.example.foodo.model;


public class RecipeModel {
    private String recipeName;
    private String description;
    private String chefName;
    private String path;

    public RecipeModel(){}

    public RecipeModel(String name, String description, String chefName, String path){
        this.setRecipeName(name);
        this.setDescription(description);
        this.setChefName(chefName);
        this.setPath(path);
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String name) {
        recipeName = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getChefName() {
        return chefName;
    }

    public void setChefName(String chefName) {
        this.chefName = chefName;
    }
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }


}

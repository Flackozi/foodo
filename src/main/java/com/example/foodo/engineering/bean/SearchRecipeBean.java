package com.example.foodo.engineering.bean;

public class SearchRecipeBean {
    private String recipeName;
    public SearchRecipeBean(String name){
        this.recipeName=name;
    }

    public SearchRecipeBean() {
    }


    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }


}

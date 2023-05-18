package com.example.foodo.model;

public class RecipeItemModel {
    private String chefName;
    private String recipeName;
    private String imgSrc;

    public RecipeItemModel(String recipeName,String chefName,String imgSrc){
        this.setRecipeName(recipeName);
        this.setChefName(chefName);
        this.setImgSrc(imgSrc);

    }

    public String getChefName() {
        return chefName;
    }

    public void setChefName(String chefName) {
        this.chefName = chefName;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }


}

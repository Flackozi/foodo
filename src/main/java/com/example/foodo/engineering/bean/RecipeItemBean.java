package com.example.foodo.engineering.bean;

import com.example.foodo.model.RecipeItemModel;

public class RecipeItemBean {

    private String recipeName;
    private String chefName;
    private String imgSrc;
    public RecipeItemBean(String recipeName, String chefName, String imgSrc){
        this.setRecipeName(recipeName);
        this.setChefName(chefName);
        this.setImgSrc(imgSrc);
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getChefName() {
        return chefName;
    }

    public void setChefName(String chefName) {
        this.chefName = chefName;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }


}

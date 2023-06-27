package com.example.foodo.model;

public class UserModel extends GenericUserModel {
    private String favoriteFood;
    private String typeOfDiet;
    private String path;

    public UserModel(String username, String favoriteFood, String typeOfDiet, String path, int profileType){
        super(username, profileType);
        this.favoriteFood=favoriteFood;
        this.typeOfDiet=typeOfDiet;
        this.path=path;
    }
    public UserModel(String username, String favoriteFood, String typeOfDiet,  String path){
        super(username);
        this.favoriteFood=favoriteFood;
        this.typeOfDiet=typeOfDiet;
        this.path=path;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    public void setFavoriteFood(String favoriteFood) {
        this.favoriteFood = favoriteFood;
    }
    public String getTypeOfDiet() {
        return typeOfDiet;
    }

    public void setTypeOfDiet(String typeOfDiet) {
        this.typeOfDiet = typeOfDiet;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}

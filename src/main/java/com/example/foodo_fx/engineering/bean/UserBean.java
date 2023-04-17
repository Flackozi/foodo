package com.example.foodo_fx.engineering.bean;

public class UserBean {
    private String username;
    private String favoriteFood;
    private String typeOfDiet;
    private int profileType;


    public UserBean(String username, String favoriteFood, String typeOfDiet, int profileType){
        this.username = username;
        this.favoriteFood = favoriteFood;
        this.typeOfDiet = typeOfDiet;
        this.profileType = profileType;
    }


    public void setUserProfileTypeBean(int profileType) {
        this.profileType = profileType;
    }

    public void setUserTypeOfDietBean(String typeOfDiet) {
        this.typeOfDiet = typeOfDiet;
    }

    public void setUserFavoriteFoodBean(String favoriteFood) {
        this.favoriteFood = favoriteFood;
    }

    public void setUserUsernameBean(String username) {
        this.username = username;
    }

    public String getUserFavoriteFoodBean(){
        return favoriteFood;
    }
    public String getUserTypeOfDietBean(){
        return typeOfDiet;
    }
    public int getUserProfileTypeBean(){
        return profileType;
    }
    public String getUserUsernameBean(){
        return username;
    }
}

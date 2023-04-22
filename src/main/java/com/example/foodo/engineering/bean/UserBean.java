package com.example.foodo.engineering.bean;

import java.io.File;

public class UserBean {
    private String username;
    private String favoriteFood;
    private String typeOfDiet;
    private int profileType;
    protected File profileImg;


    public UserBean(String username, String favoriteFood, String typeOfDiet, int profileType, File profileImg){
        this.username = username;
        this.favoriteFood = favoriteFood;
        this.typeOfDiet = typeOfDiet;
        this.profileType = profileType;
        this.profileImg=profileImg;
    }

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
    public File getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(File profileImg) {
        this.profileImg = profileImg;
    }
}

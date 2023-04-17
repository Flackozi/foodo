package com.example.foodo.engineering.bean;

public class ChefBean {
    private String username;
    private String typeOfCuisine;
    private String workplace;
    private int profileType;

    //public ChefBean() {}


    public ChefBean(String username,String typeOfCuisine, String workplace, int profileType){
        this.username = username;
        this.typeOfCuisine = typeOfCuisine;
        this.workplace = workplace;
        this.profileType = profileType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTypeOfCuisine() {
        return typeOfCuisine;
    }

    public void setTypeOfCuisine(String typeOfCuisine) {
        this.typeOfCuisine = typeOfCuisine;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public int getProfileType() {
        return profileType;
    }

    public void setProfileType(int profileType) {
        this.profileType = profileType;
    }

}

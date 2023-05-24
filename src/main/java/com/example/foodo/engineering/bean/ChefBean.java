package com.example.foodo.engineering.bean;

public class ChefBean {
    private String username;
    private String typeOfCuisine;
    private String workplace;
    private String email;
    private String number;
    private  String location;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    private int profileType;

    public ChefBean() {}


    public ChefBean(String username,String typeOfCuisine, String workplace, int profileType, String email, String number, String location){
        this.username = username;
        this.typeOfCuisine = typeOfCuisine;
        this.workplace = workplace;
        this.profileType = profileType;
        this.email = email;
        this.number = number;
        this.location = location;
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

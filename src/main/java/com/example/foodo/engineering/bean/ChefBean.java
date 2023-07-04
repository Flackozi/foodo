package com.example.foodo.engineering.bean;

public class ChefBean {
    private String username;
    private String typeOfCuisine;
    private String workplace;
    private String email;
    private String number;
    private  String location;
    private String path;

    public ChefBean() {
        //coastruttore di default
    }
    public void setPath(String path) {
        this.path = path;
    }
    public String getPath() {
        return path;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    public String getNumber() {
        return number;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    private int profileType;


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

    public void setProfileType(int profileType) {
        this.profileType = profileType;
    }

}

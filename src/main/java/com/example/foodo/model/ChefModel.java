package com.example.foodo.model;

public class ChefModel extends GenericUserModel{
    String typeOfCuisine;
    String workplace;
    String email;
    String number;
    String location;

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

    public ChefModel(String username){
        super(username);

    }
    public ChefModel(String username, String typeOfCuisine, String workplace, int profileType, String email, String number, String location){
        super(username,profileType);
        this.typeOfCuisine=typeOfCuisine;
        this.workplace=workplace;
        this.email = email;
        this.number = number;
        this.location = location;
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

}

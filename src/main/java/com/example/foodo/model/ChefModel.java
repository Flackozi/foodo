package com.example.foodo.model;

public class ChefModel extends GenericUserModel{
    String typeOfCuisine;
    String workplace;
    public ChefModel(String username){
        super(username);

    }
    public ChefModel(String username, String typeOfCuisine, String workplace, int profileType){
        super(username,profileType);
        this.typeOfCuisine=typeOfCuisine;
        this.workplace=workplace;
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

package com.example.foodo.engineering.bean;

import javafx.scene.control.CheckBox;
import javafx.scene.control.TableView;

public class SearchBean {

    private String searchText;
    private Boolean spices;
    private Boolean fruit;
    private Boolean meat;
    private Boolean vegetable;
    private Boolean sweet;
    private Boolean liquid;
    private Boolean fish;

    public SearchBean(){
        //costruttore di default
    }



    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public String getSearchText() {
        return searchText;
    }
    public void setSpices(Boolean spices) {
        this.spices = spices;
    }
    public Boolean getSpices() {
        return spices;
    }

    public Boolean getFruit() {
        return fruit;
    }

    public void setFruit(Boolean fruit) {
        this.fruit = fruit;
    }

    public Boolean getMeat() {
        return meat;
    }

    public void setMeat(Boolean meat) {
        this.meat = meat;
    }


    public void setVegetable(Boolean vegetable) {
        this.vegetable = vegetable;
    }
    public Boolean getVegetable() {
        return vegetable;
    }

    public Boolean getSweet() {
        return sweet;
    }

    public void setSweet(Boolean sweet) {
        this.sweet = sweet;
    }


    public void setLiquid(Boolean liquid) {
        this.liquid = liquid;
    }
    public Boolean getLiquid() {
        return liquid;
    }
    public void setFish(Boolean fish) {
        this.fish = fish;
    }
    public Boolean getFish() {
        return fish;
    }





}

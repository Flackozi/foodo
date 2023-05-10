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

    public SearchBean(String searchText, Boolean spices, Boolean fruit, Boolean meat, Boolean vegetable, Boolean sweet, Boolean liquid, Boolean fish){
        this.setSearchText(searchText);
        this.setSpices(spices);
        this.setFruit(fruit);
        this.setMeat(meat);
        this.setVegetable(vegetable);
        this.setSweet(sweet);
        this.setLiquid(liquid);
        this.setFish(fish);
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public Boolean getSpices() {
        return spices;
    }

    public void setSpices(Boolean spices) {
        this.spices = spices;
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

    public Boolean getVegetable() {
        return vegetable;
    }

    public void setVegetable(Boolean vegetable) {
        this.vegetable = vegetable;
    }

    public Boolean getSweet() {
        return sweet;
    }

    public void setSweet(Boolean sweet) {
        this.sweet = sweet;
    }

    public Boolean getLiquid() {
        return liquid;
    }

    public void setLiquid(Boolean liquid) {
        this.liquid = liquid;
    }

    public Boolean getFish() {
        return fish;
    }

    public void setFish(Boolean fish) {
        this.fish = fish;
    }




}

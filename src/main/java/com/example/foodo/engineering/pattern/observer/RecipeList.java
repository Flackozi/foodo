package com.example.foodo.engineering.pattern.observer;

import com.example.foodo.engineering.bean.RecipeBean;
import com.example.foodo.model.ChefModel;
import com.example.foodo.model.RecipeModel;

import java.util.ArrayList;
import java.util.List;

public class RecipeList extends Subject{

    private final List<RecipeModel> recipeModelList= new ArrayList<>();
    private ChefModel chef;
    protected RecipeList(Observer observer, List<RecipeModel> recipeModelList, ChefModel chef) {
        super(observer);
        this.chef= chef;
        for(RecipeModel recipe: recipeModelList){
            this.addRecipe(recipe);
        }
    }

    private void addRecipe(RecipeModel recipe) {
        this.recipeModelList.add(recipe);
        RecipeBean recipeBean= new RecipeBean(recipe.getRecipeName(), recipe.getDescription(), recipe.getChefName(), recipe.getPath());
        this.notifyObservers(recipeBean);
    }

    public ChefModel getChef(){return chef;}

    public void setChef(ChefModel chef) {
        this.chef = chef;
    }

}

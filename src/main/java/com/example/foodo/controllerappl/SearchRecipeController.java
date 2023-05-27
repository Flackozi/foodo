package com.example.foodo.controllerappl;

import com.example.foodo.engineering.bean.RecipeItemBean;
import com.example.foodo.engineering.bean.SearchRecipeBean;
import com.example.foodo.engineering.dao.RecipeDAO;
import com.example.foodo.model.RecipeModel;

import java.util.ArrayList;
import java.util.List;

public class SearchRecipeController {


    public List<RecipeItemBean> searchRecipe(SearchRecipeBean searchRecipeBean) {
        RecipeDAO recipeDAO= new RecipeDAO();
        List<RecipeModel> recipeModels= new ArrayList<>();
        List<RecipeItemBean> recipeItemBeans= new ArrayList<>();
        recipeModels=recipeDAO.findRecipe(searchRecipeBean.getRecipeName());
        int i;
        for(i=0; i<recipeModels.size(); i++){
            String chefName= recipeModels.get(i).getChefName();
            String recipeName= recipeModels.get(i).getRecipeName();
            String path= recipeModels.get(i).getPath();
            RecipeItemBean recipeItemBean= new RecipeItemBean(recipeName, chefName, path);
            recipeItemBeans.add(recipeItemBean);
        }
        return recipeItemBeans;
    }
}

package com.example.foodo.controllerappl;

import com.example.foodo.engineering.bean.RecipeBean;
import com.example.foodo.engineering.bean.SearchRecipeBean;
import com.example.foodo.engineering.dao.RecipeDAO;
import com.example.foodo.engineering.exception.RecipeNotFoundException;
import com.example.foodo.engineering.utils.ExceptionController;
import com.example.foodo.model.RecipeModel;

import java.util.ArrayList;
import java.util.List;

public class SearchRecipeController {


    public List<RecipeBean> searchRecipe(SearchRecipeBean searchRecipeBean) throws RecipeNotFoundException{
        RecipeDAO recipeDAO= new RecipeDAO();
        List<RecipeModel> recipeModels= new ArrayList<>();
        List<RecipeBean> recipeBeans= new ArrayList<>();
        recipeModels=recipeDAO.findRecipe(searchRecipeBean.getRecipeName());
        if(recipeModels.isEmpty()){
            throw new RecipeNotFoundException();
        }else{
            int i;
            for(i=0; i<recipeModels.size(); i++){
                String chefName= recipeModels.get(i).getChefName();
                String recipeName= recipeModels.get(i).getRecipeName();
                String path= recipeModels.get(i).getPath();
                RecipeBean recipeBean= new RecipeBean(recipeName, chefName, path);
                recipeBeans.add(recipeBean);
            }
        }
        return recipeBeans;
    }
}

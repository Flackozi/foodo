package com.example.foodo.controllerappl;

import com.example.foodo.engineering.bean.RecipeBean;
import com.example.foodo.engineering.dao.RecipeDAO;
import com.example.foodo.model.RecipeModel;

import java.sql.SQLException;

public class RecipeController {


    public void saveRecipe(RecipeBean recipeBean) throws SQLException {
        RecipeDAO recipeDAO=new RecipeDAO();
        RecipeModel recipeModel= new RecipeModel(recipeBean.getRecipeName(), recipeBean.getDescription(), recipeBean.getChefName());
        recipeDAO.AddRecipe(recipeModel);

    }
}

package com.example.foodo.controllerappl;

import com.example.foodo.engineering.bean.IngredientBean;
import com.example.foodo.engineering.bean.RecipeBean;
import com.example.foodo.engineering.dao.IngredientDAO;
import com.example.foodo.engineering.dao.RecipeDAO;
import com.example.foodo.model.RecipeModel;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;

public class RecipeController {


    public void saveRecipe(RecipeBean recipeBean) throws SQLException, FileNotFoundException {
        RecipeDAO recipeDAO=new RecipeDAO();
        RecipeModel recipeModel= new RecipeModel(recipeBean.getRecipeName(), recipeBean.getDescription(), recipeBean.getChefName(), recipeBean.getRecipeImage());
        recipeDAO.AddRecipe(recipeModel);

    }

    public void saveIngredients(List<IngredientBean> ingredients) {
        IngredientDAO ingredientDAO=new IngredientDAO();

    }
}

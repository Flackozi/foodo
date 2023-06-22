package com.example.foodo.controllerappl;

import com.example.foodo.engineering.bean.IngredientBean;
import com.example.foodo.engineering.bean.RecipeBean;
import com.example.foodo.engineering.dao.IngredientDAO;
import com.example.foodo.engineering.dao.RecipeDAO;
import com.example.foodo.engineering.exception.ConnectionDbException;
import com.example.foodo.model.IngredientModel;
import com.example.foodo.model.RecipeModel;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class RecipeController {

    private int recipeId;

    public int saveRecipe(RecipeBean recipeBean) throws SQLException, ConnectionDbException {
        recipeId=-1;
        RecipeDAO recipeDAO=new RecipeDAO();
        RecipeModel recipeModel= new RecipeModel(recipeBean.getRecipeName(), recipeBean.getDescription(), recipeBean.getChefName(), recipeBean.getPath());
        RecipeDAO.AddRecipe(recipeModel);
        recipeId=recipeDAO.takeRecipeId(recipeModel);
        return recipeId;
    }

    public void saveIngredients(List<IngredientBean> ingredientBeans) {
        List<IngredientModel> ingredients= new ArrayList<>();
        int i = 0;
        int lenght = ingredientBeans.size();
        do{
            IngredientBean ingredientBean=ingredientBeans.get(i);
            i++;
            IngredientModel ingredientModel = new IngredientModel(ingredientBean.getName(), ingredientBean.getQuantity());
            ingredients.add(ingredientModel);
        }while(i != lenght);
        IngredientDAO.addIngredient(ingredients, recipeId);
    }
}

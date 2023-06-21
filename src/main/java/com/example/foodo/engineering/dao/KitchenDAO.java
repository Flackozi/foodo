package com.example.foodo.engineering.dao;

import com.example.foodo.engineering.connection.ConnectionDB;
import com.example.foodo.engineering.exception.ConnectionDbException;
import com.example.foodo.model.KitchenModel;
import com.example.foodo.engineering.dao.queries.BasicQueries;
import com.example.foodo.model.RecipeModel;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class KitchenDAO {
    public List<RecipeModel> searchProduct(KitchenModel kitchenModel) throws ConnectionDbException, SQLException {
        Statement stmt;
        List<RecipeModel> recipeModels= new ArrayList<>();

        stmt= ConnectionDB.getConnection();
        ResultSet resultSet=BasicQueries.retriveRecipeId(stmt, kitchenModel.getIngredient1(), kitchenModel.getIngredient2(), kitchenModel.getIngredient3(), kitchenModel.getIngredient4(), kitchenModel.getIngredient5());

        List<Integer> idList= new ArrayList<>();
        int i=0;
        while(resultSet.next()){
            Integer recipeId= resultSet.getInt("recipeId");
            idList.add(recipeId);
        }

        for(i=0; i< idList.size(); i++){
            ResultSet resultSet1= BasicQueries.findRecipe(stmt, idList.get(i));
            while(resultSet1.next()){
                String recipeName = resultSet1.getString("recipeName");
                String description = resultSet1.getString("description");
                String chefName = resultSet1.getString("chefName");
                String path = resultSet1.getString("image");

                RecipeModel recipeModel = new RecipeModel(recipeName, description, chefName, path);
                recipeModels.add(recipeModel);
            }
        }
        return recipeModels;
    }
}

package com.example.foodo.engineering.dao;

import com.example.foodo.engineering.connection.ConnectionDB;
import com.example.foodo.engineering.exception.ConnectionDbException;
import com.example.foodo.model.KitchenModel;
import com.example.foodo.engineering.dao.queries.BasicQueries;
import com.example.foodo.model.RecipeItemModel;
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
        String ingredient1= kitchenModel.getIngredient1();
        String ingredient2= kitchenModel.getIngredient2();
        String ingredient3= kitchenModel.getIngredient3();
        String ingredient4= kitchenModel.getIngredient4();
        String ingredient5= kitchenModel.getIngredient5();

        stmt= ConnectionDB.getConnection();
//        if(ingredient2== null){
//            ResultSet resultSet=BasicQueries.retriveRecipeId1(stmt, ingredient1);
//        }else if (ingredient3==null) {
//            ResultSet resultSet=BasicQueries.retriveRecipeId2(stmt, ingredient1, ingredient2);
//        }else if (ingredient4== null){
//            ResultSet resultSet=BasicQueries.retriveRecipeId3(stmt, ingredient1, ingredient2, ingredient3);
//        }else if (ingredient5== null){
//            ResultSet resultSet=BasicQueries.retriveRecipeId4(stmt, ingredient1, ingredient2, ingredient3, ingredient4);
//        }else{
//            ResultSet resultSet=BasicQueries.retriveRecipeId5(stmt, ingredient1, ingredient2, ingredient3, ingredient4, ingredient5);
//        }
        ResultSet resultSet=BasicQueries.retriveRecipeId(stmt, kitchenModel.getIngredient1(), kitchenModel.getIngredient2(), kitchenModel.getIngredient3(), kitchenModel.getIngredient4(), kitchenModel.getIngredient5());

        List<Integer> idList= new ArrayList<>();
        int i=0;
        while(resultSet.next()){
            Integer recipeId= resultSet.getInt("recipeId");
            idList.add(recipeId);
        }

        for(i=0; i< idList.size(); i++){
            ResultSet resultSet1= BasicQueries.findRecipe(stmt, idList.get(i));
            int j=0;
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

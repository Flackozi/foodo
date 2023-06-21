package com.example.foodo.engineering.dao;

import com.example.foodo.engineering.connection.ConnectionDB;
import com.example.foodo.model.IngredientModel;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class IngredientDAO {
    public static void addIngredient(List<IngredientModel> ingredients, int recipeId) {
        PreparedStatement preparedStatement;
        try{
            int i = 0;
            int lenght = ingredients.size();
            do{
                IngredientModel ingredientModel=ingredients.get(i);
                i++;
                preparedStatement= ConnectionDB.addIngredient();
                System.out.print(recipeId);
                preparedStatement.setString(1, ingredientModel.getName());
                preparedStatement.setString(2, ingredientModel.getQuantity());
                preparedStatement.setInt(3, recipeId);
                preparedStatement.executeUpdate();
            }while(i != lenght);

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}

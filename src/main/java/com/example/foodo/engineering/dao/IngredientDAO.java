package com.example.foodo.engineering.dao;

import com.example.foodo.engineering.bean.IngredientBean;
import com.example.foodo.engineering.connection.ConnectionDB;
import com.example.foodo.engineering.exception.ConnectionDbException;
import com.example.foodo.model.IngredientModel;
import com.example.foodo.model.RecipeModel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class IngredientDAO {
    public static void addIngredient(List<IngredientModel> ingredients) {
        Statement stmt;
        PreparedStatement preparedStatement;
        try{
            stmt = ConnectionDB.getConnection();
            int i = 0;
            int lenght = ingredients.size();
            do{
                IngredientModel ingredientModel=ingredients.get(i);
                i++;
                preparedStatement= ConnectionDB.addIngredient();
                preparedStatement.setString(1, ingredientModel.getName());
                preparedStatement.setString(2, ingredientModel.getQuantity());
                preparedStatement.executeUpdate();
            }while(i != lenght);

        }catch(SQLException | ConnectionDbException e){
            e.printStackTrace();
        }
    }
}

package com.example.foodo.engineering.dao;


import com.example.foodo.engineering.connection.ConnectionDB;
import com.example.foodo.engineering.exception.ConnectionDbException;
import com.example.foodo.model.ProductModel;
import com.example.foodo.model.RecipeModel;
import com.example.foodo.engineering.dao.queries.BasicQueries;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.*;

public class RecipeDAO {
    public static void AddRecipe(RecipeModel recipe) throws SQLException, FileNotFoundException {
        Statement stmt;
        PreparedStatement preparedStatement;
        try{
            stmt = ConnectionDB.getConnection();
            preparedStatement= ConnectionDB.addRecipe();
            preparedStatement.setString(1, recipe.getRecipeName());
            preparedStatement.setString(2, recipe.getDescription());
            preparedStatement.setString(3, recipe.getChefName());
            preparedStatement.setString(4, recipe.getPath());

            preparedStatement.executeUpdate();
        }catch(SQLException | ConnectionDbException e){
            e.printStackTrace();
        }

    }

    public int TakeRecipeId(RecipeModel recipeModel) throws ConnectionDbException, SQLException {
        Statement stmt;
        int recipeId=0;

        try{
        stmt=ConnectionDB.getConnection();
        ResultSet resultSet=BasicQueries.retrieveRecipeId(stmt, recipeModel.getRecipeName(), recipeModel.getChefName(), recipeModel.getDescription());
        while(resultSet.next()){
            recipeId = resultSet.getInt(1);
        }
        System.out.print(recipeId);
        }catch(SQLException | ConnectionDbException e){
            e.printStackTrace();;
        }
        return recipeId;
    }
}

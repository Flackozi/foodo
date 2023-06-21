package com.example.foodo.engineering.dao;


import com.example.foodo.engineering.connection.ConnectionDB;
import com.example.foodo.engineering.exception.ConnectionDbException;
import com.example.foodo.model.RecipeModel;
import com.example.foodo.engineering.dao.queries.BasicQueries;


import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecipeDAO {

    public static final String recipeId="recipeId";
    public static void AddRecipe(RecipeModel recipe) {

        try{
            Statement stmt;
            PreparedStatement preparedStatement;
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

    public int takeRecipeId(RecipeModel recipeModel) throws ConnectionDbException, SQLException {
        Statement stmt;
        int recipeId=0;

        try{
        stmt=ConnectionDB.getConnection();
        ResultSet resultSet=BasicQueries.retrieveRecipeId(stmt, recipeModel.getRecipeName(), recipeModel.getChefName(), recipeModel.getDescription());
        while(resultSet.next()){
            recipeId = resultSet.getInt(1);
        }

        }catch(SQLException | ConnectionDbException e){
            e.printStackTrace();
        }
        return recipeId;
    }


    public List<RecipeModel> findRecipe(String recipeName) {
        List<RecipeModel> recipeModels= new ArrayList<>();
        RecipeModel recipeModel=new RecipeModel();
        Statement stmt;
        try{
            stmt=ConnectionDB.getConnection();
            ResultSet resultSet= BasicQueries.searchRecipe(stmt, recipeName);
            while(resultSet.next()){
                recipeModel.setRecipeName(recipeName);
                recipeModel.setChefName(resultSet.getString("chefName"));
                recipeModel.setDescription(resultSet.getString("description"));
                recipeModel.setPath(resultSet.getString("image"));
                recipeModels.add(recipeModel);
            }
        }catch(SQLException | ConnectionDbException e){
            e.printStackTrace();
        }
        return recipeModels;
    }

    public String retriveDescription(String rname) {
        Statement stmt;
        String description = null;

        try{
            stmt = ConnectionDB.getConnection();
            ResultSet resultSet = BasicQueries.retriveRecipeId2(stmt, rname);
            resultSet.first();
            int id = resultSet.getInt(recipeId);
            ResultSet resultSet1 = BasicQueries.searchDescription(stmt, id);
            resultSet1.first();
            description = resultSet1.getString("description");
        }catch(SQLException | ConnectionDbException e){
            e.printStackTrace();
        }
        return description;
    }

    public void setReview(float value, String name) {
        Statement stmt;

        PreparedStatement preparedStatement;
        try{
            stmt = ConnectionDB.getConnection();
            ResultSet resultSet = BasicQueries.retriveRecipeId2(stmt, name);
            resultSet.first();
            int id = resultSet.getInt(recipeId);
            preparedStatement = ConnectionDB.setReview();
            preparedStatement.setInt(1, id);
            preparedStatement.setFloat(2, value);
            preparedStatement.executeUpdate();
        }catch(SQLException | ConnectionDbException e){
            e.printStackTrace();
        }
    }

    public String retrivePath(String rname) {
        Statement stmt;
        String path = null;

        try{
            stmt = ConnectionDB.getConnection();
            ResultSet resultSet = BasicQueries.retriveRecipeId2(stmt, rname);
            resultSet.first();
            int id = resultSet.getInt(recipeId);
            ResultSet resultSet1 = BasicQueries.retrieveImg(stmt, id);
            resultSet1.first();
            path = resultSet1.getString("image");
        }catch(SQLException | ConnectionDbException e){
            e.printStackTrace();
        }
        return path;
    }

    public float setAverage(String rname, String chefName) {
        Statement stmt;
        float average=0;
        int i=0;
        int sum=0;
        int rate=0;
        try{
            stmt = ConnectionDB.getConnection();
            ResultSet resultSet = BasicQueries.retriveRecipeId3(stmt, rname, chefName);
            resultSet.first();
            int id= resultSet.getInt(recipeId);
            ResultSet resultSet1= BasicQueries.getReview(stmt, id);

            while(resultSet1.next()){
                rate=resultSet1.getInt("rate");
                sum=sum+rate;

                i++;
            }
            if(sum==0) return 0;
            average= (float) sum /i;
        }catch(SQLException | ConnectionDbException e){
            e.printStackTrace();
        }
        return average;
    }

    public void deleteRecipe(String recipeName, String chefName) {
        Statement stmt;
        int id;

        try {
            stmt = ConnectionDB.getConnection();
            ResultSet resultSet= BasicQueries.retriveRecipeId3(stmt, recipeName, chefName);
            resultSet.first();
            id=resultSet.getInt(1);
            BasicQueries.deleteIngredients(stmt, id);
            BasicQueries.deleteReview(stmt, id);
            BasicQueries.deleteRecipe(stmt, id);
        }catch( SQLException | ConnectionDbException e){
                e.printStackTrace();
        }
    }
}

package com.example.foodo.engineering.dao.queries;

import java.sql.SQLException;
import java.sql.*;
import java.util.Date;

public class BasicQueries {



    private BasicQueries(){}

    public static ResultSet checkLogin(Statement statement, String username, String password) throws SQLException {
        String sql = "SELECT CASE WHEN EXISTS (SELECT username, password FROM chef_table WHERE username = '" + username + "' AND password = '" + password + "') THEN 1 WHEN EXISTS (SELECT username, password FROM user_table WHERE username = '" + username + "' AND password = '" + password + "') THEN 2 END;";
        return statement.executeQuery(sql);
    }

    public static ResultSet selectUserByUsername(Statement stmt, String username) throws SQLException {
        String sql = "SELECT * FROM user_table WHERE username = '" + username + "';";
        return stmt.executeQuery(sql);
    }

    public static ResultSet selectChefByUsername(Statement stmt, String username) throws SQLException{
        String sql="SELECT * FROM chef_table WHERE username = '" + username + "';";
        return stmt.executeQuery(sql);
    }

    public static void InsertProduct(Statement stmt, String name, int quantity, Date expiration, String type) throws SQLException{
        String updateStatement  = String.format("INSERT INTO pantry set name=%s, quantity=%d, expiration=%d/%m/%Y type=%s", name, quantity, expiration, type);
        stmt.executeQuery(updateStatement);
    }

    public static ResultSet retriveProduct(Statement stmt) throws SQLException{
        String sql = "SELECT * FROM pantry;";
        return stmt.executeQuery(sql);
    }

    public static void deleteProduct(Statement stmt, String name) throws SQLException {
        String updateStatement= String.format("DELETE FROM pantry WHERE name = '%s'", name);
        stmt.executeUpdate(updateStatement);
    }

    public static ResultSet retriveByType(Statement stmt, String type) throws  SQLException{

        String sql = "SELECT * FROM pantry WHERE type = '" + type + "';";
        return stmt.executeQuery(sql);
    }

    public static ResultSet retriveByText(Statement stmt, String searchText) throws SQLException {
        String sql = "SELECT * FROM pantry WHERE name = '" + searchText + "';";
        return stmt.executeQuery(sql);
    }

    public static ResultSet retriveItem(Statement stmt, String name) throws SQLException {
        String sql = "SELECT * FROM recipes WHERE chefName = '" + name +"';";
        return stmt.executeQuery(sql);
    }

    public static ResultSet retriveFavoriteChef(Statement stmt, String userName) throws SQLException {
        String sql = "SELECT * FROM favorite WHERE userName = '" + userName + "';";
        return stmt.executeQuery(sql);
    }

    public static ResultSet retrieveRecipeId(Statement stmt, String recipeName, String chefName, String description ) throws SQLException {
        String sql = "SELECT recipeId FROM recipes WHERE recipeName = '" + recipeName + "' AND description = '" + description + "' AND chefName = '" + chefName + "';";
        //String sql = "SELECT recipeId FROM recipes WHERE recipeName = 'cannoli' AND description = 'bene' AND chefName = 'carlo';";
        return stmt.executeQuery(sql);
    }

    public static ResultSet retriveRecipeId(Statement stmt, String ingredient1, String ingredient2, String ingredient3, String ingredient4, String ingredient5) throws SQLException {

        if(ingredient2.isEmpty()){
            String sql= "SELECT recipeId FROM ingredients WHERE name= '" + ingredient1 + "' ;";
            return stmt.executeQuery(sql);
        }else if (ingredient3.isEmpty()) {
            String sql = "SELECT recipeId FROM ingredients WHERE name= '" + ingredient1 + "' AND recipeId in (SELECT recipeId FROM ingredients WHERE name= '" + ingredient2 + "');";
            return stmt.executeQuery(sql);
        }else if (ingredient4.isEmpty()){
            String sql= "SELECT recipeId FROM ingredients WHERE name= '" + ingredient1 + "' AND recipeId in (SELECT recipeId FROM ingredients WHERE name= '" + ingredient2 + "') AND recipeId in (SELECT recipeId FROM ingredients WHERE name= '" + ingredient3 + "');";
            return stmt.executeQuery(sql);
        }else if (ingredient4.isEmpty()){
            String sql= "SELECT recipeId FROM ingredients WHERE name= '" + ingredient1 + "' AND recipeId in (SELECT recipeId FROM ingredients WHERE name= '" + ingredient2 + "') AND recipeId in (SELECT recipeId FROM ingredients WHERE name= '" + ingredient3 + "');";
            return stmt.executeQuery(sql);
        } else if (ingredient5.isEmpty()){
            String sql= "SELECT recipeId FROM ingredients WHERE name= '" + ingredient1 + "' AND recipeId in (SELECT recipeId FROM ingredients WHERE name= '" + ingredient2 + "') AND recipeId in (SELECT recipeId FROM ingredients WHERE name= '" + ingredient3 + "') AND recipeId in (SELECT recipeId FROM ingredients WHERE name= '" + ingredient4 + "');";
            return stmt.executeQuery(sql);
        }else{
            String sql="SELECT recipeId FROM ingredients WHERE name= '" + ingredient1 + "' AND recipeId in (SELECT recipeId FROM ingredients WHERE name= '" + ingredient2 + "') AND recipeId in (SELECT recipeId FROM ingredients WHERE name= '" + ingredient3 + "') AND recipeId in (SELECT recipeId FROM ingredients WHERE name= '" + ingredient4 + "') AND recipeId in (SELECT recipeId FROM ingredients WHERE name= '" + ingredient4 + "');";
            return stmt.executeQuery(sql);
        }

    }

    public static ResultSet findRecipe(Statement stmt, Integer recipeId) throws SQLException {
        String sql= "SELECT * FROM recipes WHERE recipeId='" + recipeId + "' ;";
        return stmt.executeQuery(sql);

    }

//    public static ResultSet retriveRecipeId1(Statement stmt, String ingredient1) throws SQLException {
//        String sql= "SELECT recipeId FROM ingredients WHERE name= '" + ingredient1 + "' ;";
//        return stmt.executeQuery(sql);
//    }
//
//    public static ResultSet retriveRecipeId2(Statement stmt, String ingredient1, String ingredient2) throws SQLException {
//        String sql = "SELECT recipeId FROM ingredients WHERE name= '" + ingredient1 + "' AND recipeId in (SELECT recipeId FROM ingredients WHERE name= '" + ingredient2 + "');";
//        return stmt.executeQuery(sql);
//    }
//
//    public static ResultSet retriveRecipeId3(Statement stmt, String ingredient1, String ingredient2, String ingredient3) throws SQLException {
//        String sql= "SELECT recipeId FROM ingredients WHERE name= '" + ingredient1 + "' AND recipeId in (SELECT recipeId FROM ingredients WHERE name= '" + ingredient2 + "') AND recipeId in (SELECT recipeId FROM ingredients WHERE name= '" + ingredient3 + "');";
//        return stmt.executeQuery(sql);
//    }
//    public static ResultSet retriveRecipeId4(Statement stmt, String ingredient1, String ingredient2, String ingredient3, String ingredient4) throws SQLException {
//        String sql= "SELECT recipeId FROM ingredients WHERE name= '" + ingredient1 + "' AND recipeId in (SELECT recipeId FROM ingredients WHERE name= '" + ingredient2 + "') AND recipeId in (SELECT recipeId FROM ingredients WHERE name= '" + ingredient3 + "') AND recipeId in (SELECT recipeId FROM ingredients WHERE name= '" + ingredient4 + "');";
//        return stmt.executeQuery(sql);
//    }
//    public static ResultSet retriveRecipeId5(Statement stmt, String ingredient1, String ingredient2, String ingredient3, String ingredient4, String ingredient5) throws SQLException {
//        String sql="SELECT recipeId FROM ingredients WHERE name= '" + ingredient1 + "' AND recipeId in (SELECT recipeId FROM ingredients WHERE name= '" + ingredient2 + "') AND recipeId in (SELECT recipeId FROM ingredients WHERE name= '" + ingredient3 + "') AND recipeId in (SELECT recipeId FROM ingredients WHERE name= '" + ingredient4 + "') AND recipeId in (SELECT recipeId FROM ingredients WHERE name= '" + ingredient4 + "');";
//        return stmt.executeQuery(sql);
//    }
}

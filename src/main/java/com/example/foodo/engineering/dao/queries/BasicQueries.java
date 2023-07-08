package com.example.foodo.engineering.dao.queries;

import java.sql.SQLException;
import java.sql.*;

public class BasicQueries {


    private BasicQueries(){}

    public static ResultSet checkLogin(Statement statement, String username, String password) throws SQLException {
        String sql = String.format("SELECT CASE WHEN EXISTS (SELECT username, password FROM chef_table WHERE username = '" + username + "' AND password = '" + password + "') THEN 1 WHEN EXISTS (SELECT username, password FROM user_table WHERE username = '" + username + "' AND password = '" + password + "') THEN 2 END;");
        return statement.executeQuery(sql);
    }

    public static ResultSet selectUserByUsername(Statement stmt, String username) throws SQLException {
        String sql = String.format("SELECT * FROM user_table WHERE username = '" + username + "';");
        return stmt.executeQuery(sql);
    }

    public static ResultSet selectChefByUsername(Statement stmt, String username) throws SQLException{
        String sql=String.format("SELECT * FROM chef_table WHERE username = '" + username + "';");
        return stmt.executeQuery(sql);
    }

    public static ResultSet retriveProduct(Statement stmt, String name) throws SQLException{
        String sql = String.format("SELECT * FROM pantry WHERE accountName= '"+ name +"';");
        return stmt.executeQuery(sql);
    }

    public static void deleteProduct(Statement stmt, String name, String userName) throws SQLException {
        String updateStatement= String.format("DELETE FROM pantry WHERE name = '%s' AND accountName= '%s'", name, userName);
        stmt.executeUpdate(updateStatement);
    }

    public static ResultSet retriveByType(Statement stmt, String type, String userName) throws  SQLException{

        String sql = String.format("SELECT * FROM pantry WHERE type = '" + type + "' AND accountName= '" + userName+"';");
        return stmt.executeQuery(sql);
    }

    public static ResultSet retriveByText(Statement stmt, String searchText) throws SQLException {
        String sql = String.format("SELECT * FROM pantry WHERE name = '" + searchText + "';");
        return stmt.executeQuery(sql);
    }

    public static ResultSet retriveItem(Statement stmt, String name) throws SQLException {
        String sql = String.format("SELECT * FROM recipes WHERE chefName = '" + name +"';");
        return stmt.executeQuery(sql);
    }

    public static ResultSet retriveFavoriteChef(Statement stmt, String userName) throws SQLException {
        String sql = String.format("SELECT * FROM favorite WHERE userName = '" + userName + "';");
        return stmt.executeQuery(sql);
    }

    public static ResultSet retrieveRecipeId(Statement stmt, String recipeName, String chefName, String description ) throws SQLException {
        String sql = String.format("SELECT recipeId FROM recipes WHERE recipeName = '" + recipeName + "' AND description = '" + description + "' AND chefName = '" + chefName + "';");
        return stmt.executeQuery(sql);
    }

    public static ResultSet retriveRecipeId(Statement stmt, String ingredient1, String ingredient2, String ingredient3, String ingredient4, String ingredient5) throws SQLException {
        String query="SELECT recipeId FROM ingredients WHERE name=";
        String and="AND recipeId in (";
        String ingr1="'" + ingredient1 + "'";
        String ingr2="'" + ingredient2 + "'";
        String ingr3="'" + ingredient3 + "'";
        String ingr4="'" + ingredient4 + "'";
        String ingr5="'" + ingredient5 + "'";

        if(ingredient2.isEmpty()){
            String sql= String.format(query + ingr1 +";");
            return stmt.executeQuery(sql);
        }else if (ingredient3.isEmpty()) {
            String sql = String.format(query + ingr1 + and + query + ingr2+ ")" +";");
            return stmt.executeQuery(sql);
        }else if (ingredient4.isEmpty()){
            String sql= String.format(query + ingr1 + and + query + ingr2+ ")" + and + query + ingr3+ ")" +";" );
            return stmt.executeQuery(sql);
        } else if (ingredient5.isEmpty()){
            String sql= String.format(query + ingr1 + and + query + ingr2+ ")" + and + query + ingr3+ ")"  + and +query + ingr4+ ")"+";");
            return stmt.executeQuery(sql);
        }else{
            String sql=String.format(query + ingr1 + and + query + ingr2+ ")" + and + query + ingr3+ ")"  + and +query + ingr4+ ")" + and +query + ingr5+ ")"+";");
            return stmt.executeQuery(sql);
        }

    }

    public static ResultSet findRecipe(Statement stmt, Integer recipeId) throws SQLException {
        String sql= String.format("SELECT * FROM recipes WHERE recipeId='" + recipeId + "' ;");
        return stmt.executeQuery(sql);

    }

    public static ResultSet searchRecipe(Statement stmt, String recipeName) throws SQLException {
        String sql= String.format("SELECT * FROM recipes WHERE recipeName='" + recipeName + "' ;");
        return stmt.executeQuery(sql);

    }


    public static ResultSet retriveRecipeIng(Statement stmt, Integer id) throws SQLException {
        String sql= String.format("SELECT * FROM ingredients WHERE recipeId='" + id + "' ;");
        return stmt.executeQuery(sql);
    }

    public static ResultSet retriveRecipeId3(Statement stmt, String rname, String chefName) throws SQLException {

        String sql= String.format("SELECT recipeId FROM recipes WHERE recipeName='" + rname + "' AND chefName='" + chefName+ "';");
        return stmt.executeQuery(sql);
    }

    public static ResultSet retriveRecipeId2(Statement stmt, String rname) throws SQLException {

        String sql= String.format("SELECT recipeId FROM recipes WHERE recipeName='" + rname + "';");
        return stmt.executeQuery(sql);
    }

    public static ResultSet searchDescription(Statement stmt, int id) throws SQLException {
        String sql= String.format("SELECT description FROM recipes WHERE recipeId='" + id + "' ;");
        return stmt.executeQuery(sql);
    }

    public static ResultSet retrieveImg(Statement stmt, int id) throws SQLException {
        String sql= String.format("SELECT image FROM recipes WHERE recipeId='" + id + "' ;");
        return stmt.executeQuery(sql);
    }

    public static ResultSet checkFollow(Statement stmt, String userName, String chefName) throws SQLException {
        String sql = String.format("SELECT CASE WHEN EXISTS (SELECT userName, chefName FROM favorite WHERE userName = '" + userName + "' AND chefName = '" + chefName + "') THEN 0 ELSE 1 END;");
        return stmt.executeQuery(sql);
    }

    public static void deleteFollow(Statement stmt, String userName, String chefName) throws SQLException {
        String updateStatement= String.format("DELETE FROM favorite WHERE userName = '%s' AND chefName = '%s' ", userName, chefName);
        stmt.executeUpdate(updateStatement);
    }

    public static ResultSet getReview(Statement stmt, int id) throws SQLException {
        String sql= String.format("SELECT rate FROM review WHERE recipeId1='" + id + "' ;");
        return stmt.executeQuery(sql);
    }

    public static void updateImage(Statement stmt, String path, String name) throws SQLException {
        String sql=String.format("UPDATE user_table SET path='" + path + "' WHERE username='" + name + "';");
        stmt.executeUpdate(sql);

    }
    public static void updateChefImage(Statement stmt, String path, String name) throws SQLException {
        String sql= String.format("UPDATE chef_table SET path='" + path + "' WHERE username='" + name + "';");
        stmt.executeUpdate(sql);

    }

    public static void deleteIngredients(Statement stmt, int id) throws SQLException{
        String sql=String.format("DELETE FROM ingredients WHERE recipeId ='" + id+"';");
        stmt.executeUpdate(sql);
    }

    public static void deleteRecipe(Statement stmt, int id) throws SQLException {
        String sql=String.format("DELETE FROM recipes WHERE recipeId ='" + id+"';");
        stmt.executeUpdate(sql);

    }

    public static void deleteReview(Statement stmt, int id) throws SQLException {
        String sql=String.format("DELETE FROM review WHERE recipeId1 ='" + id+"';");
        stmt.executeUpdate(sql);

    }
}

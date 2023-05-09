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
}

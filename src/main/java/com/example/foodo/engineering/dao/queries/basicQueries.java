package com.example.foodo.engineering.dao.queries;

import java.sql.SQLException;
import java.sql.*;

public class basicQueries {

    private basicQueries(){}

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
}

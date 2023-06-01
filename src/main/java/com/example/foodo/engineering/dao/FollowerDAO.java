package com.example.foodo.engineering.dao;

import com.example.foodo.engineering.connection.ConnectionDB;
import com.example.foodo.engineering.dao.queries.BasicQueries;
import com.example.foodo.engineering.exception.ConnectionDbException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FollowerDAO {
    public int checkFollow(String userName, String chefName) {
        Statement stmt;
        int follow = 0;
        try{
            stmt = ConnectionDB.getConnection();
            ResultSet resultSet = BasicQueries.checkFollow(stmt, userName, chefName);
            resultSet.next();
            resultSet.first();
            follow=resultSet.getInt(1);
            System.out.print(follow);
        }catch(SQLException | ConnectionDbException e){
            e.printStackTrace();
        }
        return follow;
    }

    public void unfollowChef(String userName, String chefName) {
        Statement stmt;
        try{
            stmt = ConnectionDB.getConnection();
            BasicQueries.deleteFollow(stmt, userName, chefName);

        }catch(SQLException | ConnectionDbException e){
            e.printStackTrace();
        }
    }

    public void followChef(String userName, String chefName) {
        PreparedStatement preparedStatement;
        try{
            preparedStatement = ConnectionDB.setFollow();
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, chefName);
            preparedStatement.executeUpdate();
        }catch(SQLException  e){
            e.printStackTrace();
        }

    }
}

package com.example.foodo.engineering.dao;

import com.example.foodo.engineering.connection.ConnectionDB;
import com.example.foodo.engineering.dao.queries.BasicQueries;

import java.sql.ResultSet;
import java.sql.*;

public class LoginDAO {
    //costruttore privato
    private LoginDAO(){}

    public static int loginCheck(String username, String password){
        Statement statement;

        int type = 0;
        try{
            statement = ConnectionDB.getConnection();
            ResultSet resultSet = BasicQueries.checkLogin(statement, username, password);
            
            resultSet.next();
            resultSet.first();

            type = resultSet.getInt(1);
            resultSet.close();

        } catch(Exception e){
            e.printStackTrace();
        }
        return type;
    }

}

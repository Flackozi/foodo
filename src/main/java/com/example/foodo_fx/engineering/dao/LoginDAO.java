package com.example.foodo_fx.engineering.dao;

import com.example.foodo_fx.engineering.connection.ConnectionDB;
import com.example.foodo_fx.engineering.dao.queries.basicQueries;

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
            ResultSet resultSet = basicQueries.checkLogin(statement, username, password);

            //verifico resultset
//            if(!resultSet.first()){
//                throws
//            }
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

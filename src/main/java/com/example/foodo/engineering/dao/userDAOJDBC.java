package com.example.foodo.engineering.dao;

import com.example.foodo.engineering.Utils.ExceptionControllerGUI;
import com.example.foodo.engineering.connection.ConnectionDB;
import com.example.foodo.engineering.dao.queries.BasicQueries;
import com.example.foodo.engineering.exception.ConnectionDbException;
import com.example.foodo.model.UserModel;
import com.example.foodo.engineering.exception.NotFoundException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class userDAOJDBC {

    public static UserModel retrieveUserByUsername(String username) throws NotFoundException {
        Statement statement;
        UserModel userModel = null;

        try{
            statement = ConnectionDB.getConnection();

            //result set query
            ResultSet resultSet = BasicQueries.selectUserByUsername(statement, username);

            //verifico result set vuoto
            if(!resultSet.first()){
                throw new NotFoundException("No user find with the username: " + username);
            }

            //riposiziono puntatore
            resultSet.first();
            do{

                userModel = getUserInfo(username, resultSet);
            }while(resultSet.next());

            //chiudo connessione
            resultSet.close();
        //manca l'exception connectionDb
        }catch (SQLException | ConnectionDbException | NotFoundException e) {
            ExceptionControllerGUI.showExceptionGUI(e.getMessage());

        }
        return userModel;
    }

    //public UserModel retriveUserByUsername(String username) throws ClassNotFoundException

    private static UserModel getUserInfo(String username, ResultSet resultSet) throws SQLException {
        String typeOfDiet = resultSet.getString("typeOfdiet");
        String favoriteFood = resultSet.getString("favoritefood");
//        int profileType= resultSet.getInt("userType");

        return new UserModel(username, favoriteFood, typeOfDiet, 2);
    }
}

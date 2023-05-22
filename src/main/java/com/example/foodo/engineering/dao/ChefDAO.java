package com.example.foodo.engineering.dao;

import com.example.foodo.engineering.dao.queries.BasicQueries;
import com.example.foodo.engineering.exception.ConnectionDbException;
import com.example.foodo.engineering.exception.NotFoundException;
import com.example.foodo.model.ChefModel;
import com.example.foodo.engineering.connection.ConnectionDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ChefDAO {

    private static final String CUISINE="typeOfCuisine";
    private static final String WORKPLACE="workplace";
    //private static final Integer CHEFTYPE="";



    public ChefDAO(){}

    public static ChefModel retrieveChefByUsername(String username) throws NotFoundException {
        Statement stmt;
        ChefModel chefModel=null;
        try{
            stmt=ConnectionDB.getConnection();

            ResultSet resultSet= BasicQueries.selectChefByUsername(stmt, username);

            if(!resultSet.first()){
                throw new NotFoundException("No chef find with the username: " + username);
            }

            resultSet.first();
            do {

                chefModel = setChefInfo(username, resultSet);
            }while(resultSet.next());
            resultSet.close();

        }
        catch(SQLException | ConnectionDbException e){
            e.printStackTrace();
        }
        return chefModel;
    }

    private static ChefModel setChefInfo(String username, ResultSet resultSet){
        ChefModel chefModel=null;
        try{
            //int chefTypeOfUser=resultSet.getInt(CHEFTYPE);
            String typeOfCuisine=resultSet.getString(CUISINE);
            String workplace=resultSet.getString(WORKPLACE);
            chefModel=new ChefModel(username, typeOfCuisine, workplace, 1);

        }
        catch(Exception e){
            e.printStackTrace();
        }        return chefModel;
    }

}

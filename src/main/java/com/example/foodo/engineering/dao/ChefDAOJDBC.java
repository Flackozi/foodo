package com.example.foodo.engineering.dao;

import com.example.foodo.engineering.dao.queries.BasicQueries;
import com.example.foodo.engineering.exception.ConnectionDbException;
import com.example.foodo.engineering.exception.NotFoundException;
import com.example.foodo.model.ChefModel;
import com.example.foodo.engineering.connection.ConnectionDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ChefDAOJDBC  extends ChefDAO{

    private static final String CUISINE="typeOfCuisine";
    private static final String WORKPLACE="workplace";
    private static final String EMAIL="email";
    private static final String NUMBER="number";
    private static final String LOCATION="location";
    private static final String PATH="path";



    public ChefDAOJDBC(){
        //costruttore di default
    }

    @Override
    public ChefModel retrieveChefByUsername(String username) {
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
        catch(SQLException | ConnectionDbException | NotFoundException e){
            e.printStackTrace();
        }
        return chefModel;
    }

    private static ChefModel setChefInfo(String username, ResultSet resultSet){
        ChefModel chefModel=null;
        try{
            String typeOfCuisine=resultSet.getString(CUISINE);
            String workplace=resultSet.getString(WORKPLACE);
            String email = resultSet.getString(EMAIL);
            String number = resultSet.getString(NUMBER);
            String location = resultSet.getString(LOCATION);
            String path= resultSet.getString(PATH);
            chefModel=new ChefModel(username);
            chefModel.setTypeOfCuisine(typeOfCuisine);
            chefModel.setWorkplace(workplace);
            chefModel.setProfileType(1);
            chefModel.setEmail(email);
            chefModel.setNumber(number);
            chefModel.setLocation(location);
            chefModel.setPath(path);

        }
        catch(Exception e){
            e.printStackTrace();
        }
        return chefModel;
    }

    public static void updateImage(String path, String username) {
        Statement statement;

        try{
            statement = ConnectionDB.getConnection();
            //result set query
            BasicQueries.updateChefImage(statement, path, username);

        }catch (SQLException | ConnectionDbException e) {
            e.printStackTrace();
        }
    }
}

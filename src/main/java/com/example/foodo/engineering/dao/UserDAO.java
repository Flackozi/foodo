package com.example.foodo.engineering.dao;

import com.example.foodo.engineering.connection.ConnectionDB;
import com.example.foodo.engineering.dao.queries.BasicQueries;
import com.example.foodo.engineering.exception.ConnectionDbException;
import com.example.foodo.engineering.exception.NotFoundException;
import com.example.foodo.model.UserModel;

import java.sql.SQLException;
import java.sql.Statement;


public abstract class UserDAO {

    private static final String USER_FILE_CSV = "src/main/file/Users.csv";

    public abstract UserModel retrieveUserByUsername(String username) throws NotFoundException;



    public static void updateImage(String path, String name) {
        Statement statement;

        try{
            statement = ConnectionDB.getConnection();
            //result set query
            BasicQueries.updateImage(statement, path, name);

        }catch (SQLException | ConnectionDbException e) {
            e.printStackTrace();
        }
    }
}

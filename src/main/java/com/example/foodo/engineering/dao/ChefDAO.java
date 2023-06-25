package com.example.foodo.engineering.dao;

import com.example.foodo.engineering.connection.ConnectionDB;
import com.example.foodo.engineering.dao.queries.BasicQueries;
import com.example.foodo.engineering.exception.ConnectionDbException;
import com.example.foodo.engineering.exception.NotFoundException;
import com.example.foodo.model.ChefModel;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class ChefDAO {
    private static final String CHEF_FILE_CSV ="src/main/file/Chef.csv";

    public abstract ChefModel retrieveChefByUsername(String username) throws IOException, NotFoundException;

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

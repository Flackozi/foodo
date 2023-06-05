package com.example.foodo.engineering.dao;

import com.example.foodo.engineering.exception.NotFoundException;
import com.example.foodo.model.UserModel;

import java.io.*;
import java.sql.ResultSet;

public class UserDAOCSV extends UserDAO{
    private static final String FileNameCSV = "src/main/file/Users.csv";
    private static final int USERNAME = 0;
    private static final int TYPEOFDIET = 1;
    private static final int FAVORITEFOOD = 2;
    private static final int PASS = 3;
    private static final int PATH = 4;

    @Override
    public UserModel retrieveUserByUsername(String username){
        UserModel userModel = null;

        try{
            File file = new File(FileNameCSV);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String row;
            String[] data;

            while((row = bufferedReader.readLine()) != null){
                data = row.split(",");
                if(username != null){
                    if(data[USERNAME].equals(username)){
                        userModel = new UserModel(data[USERNAME], data[TYPEOFDIET], data[FAVORITEFOOD], data[PASS], data[PATH]);
                    }
                }
            }

            if(userModel == null){
                throw new NotFoundException("User Not Found");
            }
            bufferedReader.close();
        } catch (IOException | NotFoundException e) {
            throw new RuntimeException(e);
        }

        return userModel;
    }


}


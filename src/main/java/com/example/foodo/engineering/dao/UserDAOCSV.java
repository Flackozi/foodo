package com.example.foodo.engineering.dao;

import com.example.foodo.engineering.exception.NotFoundException;
import com.example.foodo.model.UserModel;

import java.io.*;

public class UserDAOCSV extends UserDAO{
    private static final String FILE_NAME_CSV = "src/main/file/Users.csv";
    private static final int USERNAME = 0;
    private static final int TYPEOFDIET = 1;
    private static final int FAVORITEFOOD = 2;
    private static final int PASS = 3;
    private static final int PATH = 4;

    @Override
    public UserModel retrieveUserByUsername(String username) throws NotFoundException, IOException {
        UserModel userModel = null;
        BufferedReader bufferedReader=null;
        try{
            File file = new File(FILE_NAME_CSV);
            bufferedReader = new BufferedReader(new FileReader(file));
            String row;
            String[] data;

            while((row = bufferedReader.readLine()) != null){
                data = row.split(",");
                if(username != null && data[USERNAME].equals(username)){
                    userModel = new UserModel(data[USERNAME], data[TYPEOFDIET], data[FAVORITEFOOD], data[PASS], data[PATH]);
                }
            }

            if(userModel == null){
                throw new NotFoundException("User Not Found");
            }
        } catch (IOException | NotFoundException e) {
            throw new NotFoundException(e.getMessage());
        }finally {
            if(bufferedReader==null){
                throw new NotFoundException("Buffered reader null");
            }
            bufferedReader.close();
        }

        return userModel;
    }


}


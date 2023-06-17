package com.example.foodo.engineering.dao;

import com.example.foodo.engineering.exception.NotFoundException;
import com.example.foodo.model.ChefModel;

import java.io.*;
import java.nio.Buffer;

public class ChefDAOCSV extends ChefDAO{

    private static final String FileNameCSV="src/main/file/Chef.csv";
    private static final int USERNAME=0;
    private static final int TYPEOFCUISINE=1;
    private static final int WORKPLACE=2;
    private static final int EMAIL=4;
    private static final int NUMBER=5;
    private static final int LOCATION=6;
    private static final int PATH=7;

    @Override
    public ChefModel retrieveChefByUsername(String username){
        ChefModel chefModel= null;

        try{
            File file= new File(FileNameCSV);
            BufferedReader bufferedReader= new BufferedReader(new FileReader(file));
            String row;
            String[] data;

            while((row=bufferedReader.readLine()) != null){
                data=row.split(",");
                if(username != null){
                    if(data[USERNAME].equals(username)) {
                        chefModel = new ChefModel(data[USERNAME], data[TYPEOFCUISINE], data[WORKPLACE], data[EMAIL], data[NUMBER], data[LOCATION], data[PATH]);
                    }
                }
            }
            if(chefModel==null){
                throw new NotFoundException("Chef Not Found");
            }
            bufferedReader.close();
        } catch (IOException | NotFoundException e) {
            throw new RuntimeException(e);
        }

        return chefModel;
    }
}

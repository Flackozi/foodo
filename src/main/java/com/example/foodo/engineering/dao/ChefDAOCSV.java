package com.example.foodo.engineering.dao;

import com.example.foodo.engineering.exception.NotFoundException;
import com.example.foodo.model.ChefModel;

import java.io.*;

public class ChefDAOCSV extends ChefDAO{

    private static final String FILE_NAME_CSV ="src/main/file/Chef.csv";
    private static final int USERNAME=0;
    private static final int TYPEOFCUISINE=1;
    private static final int WORKPLACE=2;
    private static final int EMAIL=4;
    private static final int NUMBER=5;
    private static final int LOCATION=6;
    private static final int PATH=7;

    @Override
    public ChefModel retrieveChefByUsername(String username) throws IOException, NotFoundException {
        ChefModel chefModel= null;
        File file= new File(FILE_NAME_CSV);
        try(BufferedReader bufferedReader= new BufferedReader(new FileReader(file))){
            String row;
            String[] data;

            while((row=bufferedReader.readLine()) != null){
                data=row.split(",");
                if(username != null  && data[USERNAME].equals(username)) {
                    chefModel = new ChefModel(data[USERNAME], data[TYPEOFCUISINE], data[WORKPLACE], data[EMAIL], data[NUMBER], data[LOCATION], data[PATH]);
                }

            }
            if(chefModel==null){
                throw new NotFoundException("Chef Not Found");
            }
        } catch (IOException | NotFoundException e) {
            throw new NotFoundException(e.getMessage());
        }

        return chefModel;
    }
}

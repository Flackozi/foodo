package com.example.foodo.engineering.pattern.factory;

import com.example.foodo.engineering.dao.*;

import java.util.Random;

public class ChefDAOFactory {
    private ChefDAOFactory(){}

    private static ChefDAOFactory instance = null;

    public static ChefDAOFactory getInstance(){
        if(instance == null){
            instance = new ChefDAOFactory();
        }
        return instance;
    }

    public ChefDAO getChefDAO(){

        Random random = new Random();
        int randomNumber = random.nextInt(10);
        System.out.print(randomNumber);
        if(randomNumber %2 == 0){
            return new ChefDAOJDBC();
        }else{
            return new ChefDAOCSV();
        }
    }
}

package com.example.foodo.engineering.pattern.factory;


import com.example.foodo.engineering.dao.UserDAO;
import com.example.foodo.engineering.dao.UserDAOCSV;
import com.example.foodo.engineering.dao.UserDAOJDBC;

import java.util.Random;

//questa classe rappresenta l'applicazione del pattern factory method
public class UserDAOFactory {

    private UserDAOFactory(){}

    private static UserDAOFactory instance = null;

    public static UserDAOFactory getInstance(){
        if(instance == null){
            instance = new UserDAOFactory();
        }
        return instance;
    }

    public UserDAO getUserDAO(){

        Random random = new Random();
        int randomNumber = random.nextInt(10);
        System.out.print(randomNumber);
        if(randomNumber %2 == 0){
            return new UserDAOJDBC();
        }else{
            return new UserDAOCSV();
        }
    }
}

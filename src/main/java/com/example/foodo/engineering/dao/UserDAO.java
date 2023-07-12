package com.example.foodo.engineering.dao;


import com.example.foodo.engineering.exception.NotFoundException;
import com.example.foodo.model.UserModel;

import java.io.IOException;



public interface  UserDAO {

    public abstract UserModel retrieveUserByUsername(String username) throws NotFoundException, IOException;


}

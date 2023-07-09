package com.example.foodo.engineering.dao;

import com.example.foodo.engineering.connection.ConnectionDB;
import com.example.foodo.engineering.dao.queries.BasicQueries;
import com.example.foodo.engineering.exception.ConnectionDbException;
import com.example.foodo.engineering.exception.NotFoundException;
import com.example.foodo.model.UserModel;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;


public interface  UserDAO {

    public abstract UserModel retrieveUserByUsername(String username) throws NotFoundException, IOException;


}

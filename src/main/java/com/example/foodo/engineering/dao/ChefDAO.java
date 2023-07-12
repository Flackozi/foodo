package com.example.foodo.engineering.dao;


import com.example.foodo.engineering.exception.NotFoundException;
import com.example.foodo.model.ChefModel;

import java.io.IOException;


public interface ChefDAO {

    public abstract ChefModel retrieveChefByUsername(String username) throws IOException, NotFoundException;


}

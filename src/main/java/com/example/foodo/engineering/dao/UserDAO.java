package com.example.foodo.engineering.dao;

import com.example.foodo.engineering.exception.NotFoundException;
import com.example.foodo.model.UserModel;

public interface UserDAO {
    UserModel retrieveUserByUsername (String username) throws NotFoundException;
}

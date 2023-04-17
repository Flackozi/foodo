package com.example.foodo_fx.engineering.dao;

import com.example.foodo_fx.engineering.exception.NotFoundException;
import com.example.foodo_fx.model.UserModel;

public interface UserDAO {
    UserModel retrieveUserByUsername (String username) throws NotFoundException;
}

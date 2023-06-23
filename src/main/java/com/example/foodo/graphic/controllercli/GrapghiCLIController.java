package com.example.foodo.graphic.controllercli;

import com.example.foodo.engineering.exception.CommandNotValidException;
import com.example.foodo.engineering.exception.ConnectionDbException;
import com.example.foodo.engineering.exception.ProductNotFoundException;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public interface GrapghiCLIController {
    void start() throws SQLException, ConnectionDbException, FileNotFoundException, ProductNotFoundException, CommandNotValidException;
}

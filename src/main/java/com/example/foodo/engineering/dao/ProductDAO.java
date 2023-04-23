package com.example.foodo.engineering.dao;

import com.example.foodo.engineering.connection.ConnectionDB;
import com.example.foodo.engineering.dao.queries.BasicQueries;
import com.example.foodo.engineering.exception.ConnectionDbException;
import com.example.foodo.model.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class ProductDAO {

    private ProductDAO(){}

    public static void InsProduct(Product product) throws SQLException{

        Statement stmt;
        PreparedStatement preparedStatement;
        try{

            stmt = ConnectionDB.getConnection();
            preparedStatement= ConnectionDB.insertProduct();
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getQuantity());
            preparedStatement.setDate(3, product.getExpiration());
            preparedStatement.setString(4, product.getTypeOfFood());
            preparedStatement.executeUpdate();

        } catch(SQLException | ConnectionDbException e){
            e.printStackTrace();
        }

    }
}

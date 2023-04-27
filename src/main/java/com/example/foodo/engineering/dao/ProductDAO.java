package com.example.foodo.engineering.dao;

import com.example.foodo.engineering.connection.ConnectionDB;
import com.example.foodo.engineering.exception.ConnectionDbException;
import com.example.foodo.model.ProductModel;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductDAO {


    public static void InsProduct(ProductModel product) throws SQLException{

        Statement stmt;
        PreparedStatement preparedStatement;
        try{

            stmt = ConnectionDB.getConnection();
            preparedStatement= ConnectionDB.insertProduct();
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getQuantity());
            preparedStatement.setString(4, product.getTypeOfFood());
            preparedStatement.setInt(3, product.getExpirationDay());
            preparedStatement.setInt(3, product.getExpirationMonth());
            preparedStatement.setInt(3, product.getExpirationYear());
            preparedStatement.executeUpdate();

        } catch(SQLException | ConnectionDbException e){
            e.printStackTrace();
        }

    }
}

package com.example.foodo.engineering.dao;

import com.example.foodo.engineering.connection.ConnectionDB;
import com.example.foodo.engineering.dao.queries.BasicQueries;
import com.example.foodo.engineering.exception.ConnectionDbException;
import com.example.foodo.model.ProductModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {


    public static void InsProduct(ProductModel product) throws SQLException{

        Statement stmt;
        PreparedStatement preparedStatement;
        try{

            stmt = ConnectionDB.getConnection();
            preparedStatement= ConnectionDB.insertProduct();
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getQuantity());
            preparedStatement.setString(3, product.getTypeOfFood());
            preparedStatement.setInt(4, product.getExpirationDay());
            preparedStatement.setInt(5, product.getExpirationMonth());
            preparedStatement.setInt(6, product.getExpirationYear());
            preparedStatement.executeUpdate();

        } catch(SQLException | ConnectionDbException e){
            e.printStackTrace();
        }

    }

    public ObservableList getAllProduct() throws ConnectionDbException, SQLException {
        Statement stmt;
        List<ProductModel> productModelList = new ArrayList<>();
        stmt = ConnectionDB.getConnection();
        ResultSet resultSet = BasicQueries.retriveProduct(stmt);
        resultSet.next();
        resultSet.first();

        do{
            String name = resultSet.getString("name");
            int quantity = resultSet.getInt("quantity");
            String type = resultSet.getString("type");
            int expDay = resultSet.getInt("expirationDay");
            int expMonth = resultSet.getInt("expirationMonth");
            int expYear = resultSet.getInt("expirationYear");
            String exp = expDay + "/" + expMonth + "/" + expYear;
            ProductModel productModel = new ProductModel(name, quantity, type, exp);
            productModelList.add(productModel);
        }while(resultSet.next());
        ObservableList obl = FXCollections.observableArrayList(productModelList);
        return obl;
    }

}

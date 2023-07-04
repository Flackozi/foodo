package com.example.foodo.engineering.dao;

import com.example.foodo.engineering.bean.ProductBean;
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

public class   ProductDAO {

    public static void insProduct(ProductModel product, String userName){


        try{
            PreparedStatement preparedStatement;
            preparedStatement= ConnectionDB.insertProduct();
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getQuantity());
            preparedStatement.setString(3, product.getTypeOfFood());
            preparedStatement.setInt(4, product.getExpirationDay());
            preparedStatement.setInt(5, product.getExpirationMonth());
            preparedStatement.setInt(6, product.getExpirationYear());
            preparedStatement.setString(7, userName);
            preparedStatement.executeUpdate();

        } catch(SQLException  e){
            e.printStackTrace();
        }

    }

    public ObservableList getAllProduct( String userName) throws ConnectionDbException, SQLException {
        Statement stmt;
        List<ProductModel> productModelList = new ArrayList<>();
        stmt = ConnectionDB.getConnection();
        ResultSet resultSet = BasicQueries.retriveProduct(stmt, userName);
        resultSet.next();
        resultSet.first();

        do{
            String name = resultSet.getString("name");
            String quantity = resultSet.getString("quantity");
            String type = resultSet.getString("type");
            int expDay = resultSet.getInt("expirationDay");
            int expMonth = resultSet.getInt("expirationMonth");
            int expYear = resultSet.getInt("expirationYear");
            String exp = expDay + "/" + expMonth + "/" + expYear;
            ProductModel productModel = new ProductModel(name, quantity, type, exp);
            productModelList.add(productModel);
        }while(resultSet.next());
        return FXCollections.observableArrayList(productModelList);
    }

    public void delProduct(ProductModel productModel, String userName) throws ConnectionDbException, SQLException {
        Statement stmt;
        stmt=ConnectionDB.getConnection();
        BasicQueries.deleteProduct(stmt, productModel.getName(), userName);
    }

    public List<ProductModel> getRecipeIng(String rname) throws ConnectionDbException, SQLException {

        Statement stmt;
        List<ProductModel> productModelList = new ArrayList<>();
        stmt = ConnectionDB.getConnection();
        ProductDAO productDAO = new ProductDAO();
        Integer id = productDAO.getRecipeId(rname);
        ResultSet resultSet = BasicQueries.retriveRecipeIng(stmt, id);
        while(resultSet.next()){
            String name = resultSet.getString("name");
            String quantity = resultSet.getString("quantity");
            ProductModel productModel = new ProductModel(name, quantity);
            productModelList.add(productModel);
        }
        return productModelList;
    }

    public Integer getRecipeId(String rname) throws ConnectionDbException, SQLException {
        Statement stmt;
        stmt = ConnectionDB.getConnection();
        ResultSet resultSet = BasicQueries.retriveRecipeId2(stmt, rname);
        resultSet.next();
        resultSet.first();
        return resultSet.getInt("recipeId");
    }
}

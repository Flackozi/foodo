package com.example.foodo.engineering.dao;

import com.example.foodo.engineering.connection.ConnectionDB;
import com.example.foodo.engineering.dao.queries.BasicQueries;
import com.example.foodo.engineering.exception.ConnectionDbException;
import com.example.foodo.engineering.exception.NotFoundException;
import com.example.foodo.model.ProductModel;
import com.example.foodo.model.SearchModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SearchDAO {



    public static List<ProductModel> retriveByTypeOfFood(String type) {
        Statement stmt;
        List<ProductModel> productModelList = new ArrayList<>();

        try{
            stmt = ConnectionDB.getConnection();
            ResultSet resultSet = BasicQueries.retriveByType(stmt, type);
            resultSet.next();
            resultSet.first();

            do{
                String name = resultSet.getString("name");
                int quantity = resultSet.getInt("quantity");
                String typeOf = resultSet.getString("type");
                int expDay = resultSet.getInt("expirationDay");
                int expMonth = resultSet.getInt("expirationMonth");
                int expYear = resultSet.getInt("expirationYear");
                String exp = expDay + "/" + expMonth + "/" + expYear;
                ProductModel productModel = new ProductModel(name, quantity, typeOf, exp);
                productModelList.add(productModel);
            }while(resultSet.next());
        }catch(SQLException | ConnectionDbException e){
            e.printStackTrace();;
        }

        return productModelList;
    }
}

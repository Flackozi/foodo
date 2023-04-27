package com.example.foodo.engineering.Utils;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class ProductDAOSupport {

    private ProductDAOSupport(){}

    public static void prepareProductInfo(PreparedStatement preparedStatement, String name, int quantity, Date date, String type) throws SQLException {
        preparedStatement.setString(1, name);
        preparedStatement.setInt(2, quantity);
        preparedStatement.setDate(3, (java.sql.Date) date);
        preparedStatement.setString(4, type);
    }


}

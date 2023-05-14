package com.example.foodo.engineering.connection;

import com.example.foodo.engineering.exception.ConnectionDbException;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

//usato il pattern singleton
public class ConnectionDB {
    private ConnectionDB(){
        //privato per evitare che altri classi facciano la new()
    }

    private static Connection connection;

    public static Statement getConnection() throws ConnectionDbException {
        Statement statement;
        try{
            myConnection();
            statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        }
        catch (SQLException e){
            throw new ConnectionDbException();
        }
        return statement;
    }

    public static void closeClonnection() throws SQLException {
        connection.close();
    }

    private static void myConnection(){
        String user;
        String password;
        String url;
        String driverClassName;

        if(connection==null){
            try{
                Properties properties=loadProperties();
                user= properties.getProperty("USER");
                password= properties.getProperty("PASS");
                url= properties.getProperty("DB_URL");
                driverClassName= properties.getProperty("DRIVER_CLASS_NAME");

                Class.forName(driverClassName);

                connection= DriverManager.getConnection(url, user, password);

            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

    }

    private static Properties loadProperties() throws IOException{
        Properties properties= new Properties();
        FileInputStream fileInputStream= new FileInputStream("src/main/java/com/example/foodo/engineering/connection/connection.properties.properties");
        properties.load(fileInputStream);
        return properties;
    }

    public static PreparedStatement insertProduct() throws SQLException{
        return connection.prepareStatement("INSERT INTO pantry (name, quantity, type, expirationDay, expirationMonth, expirationYear) VALUES (?,?,?,?,?,?)");
    }

    public static PreparedStatement addRecipe() throws SQLException {
        return connection.prepareStatement("INSERT INTO recipes (recipeName, description, chefName) VALUES (?,?,?)");
    }
}


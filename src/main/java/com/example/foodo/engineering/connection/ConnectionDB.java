package com.example.foodo.engineering.connection;

import com.example.foodo.engineering.exception.ConnectionDbException;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Objects;
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

    private static Properties loadProperties() throws IOException, ConnectionDbException {
        FileInputStream fileInputStream = null;
        try{
            Properties properties= new Properties();
            fileInputStream= new FileInputStream("src/main/java/com/example/foodo/engineering/connection/connection.properties.properties");
            properties.load(fileInputStream);

            return properties;
        } catch (Exception e) {
            throw new ConnectionDbException();
        } finally {
            Objects.requireNonNull(fileInputStream).close();
        }

    }

    public static PreparedStatement insertProduct() throws SQLException{
        return connection.prepareStatement("INSERT INTO pantry (name, quantity, type, expirationDay, expirationMonth, expirationYear, accountName) VALUES (?,?,?,?,?,?,?)");
    }

    public static PreparedStatement addRecipe() throws SQLException {
        return connection.prepareStatement("INSERT INTO recipes (recipeName, description, chefName, image) VALUES (?,?,?,?)");
    }

    public static PreparedStatement addIngredient() throws SQLException{
        return connection.prepareStatement("INSERT INTO ingredients (name, quantity, recipeId) VALUES (?,?,?)");
    }

    public static PreparedStatement setReview() throws SQLException{
        return connection.prepareStatement("INSERT INTO review (recipeId1, rate) VALUES (?,?)");
    }

    public static PreparedStatement setFollow() throws SQLException{
        return connection.prepareStatement("INSERT INTO favorite (userName, chefName) VALUES (?,?)");
    }
    public static PreparedStatement setImg(String path, String name) throws SQLException{
        return connection.prepareStatement("UPDATE user_table SET path='" + path + "' WHERE username='" + name + "';");
    }

}


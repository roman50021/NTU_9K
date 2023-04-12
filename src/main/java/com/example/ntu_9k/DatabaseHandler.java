package com.example.ntu_9k;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class DatabaseHandler {

    Connection connection;
    ResultSet resSet = null;

    public Connection getDBConnection(){
        String connectionString = "jbdc:mysql://localhost:3306/ntuk";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            connection = DriverManager.getConnection(connectionString, "root", "sabarak");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public ResultSet getMovies(){
        String getMovies = "SELECT * FROM movies";
        PreparedStatement prst = null;
        try {
            prst = getDBConnection().prepareStatement(getMovies);
            resSet = prst.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return resSet;
    }
}

package com.example.demo.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnection {
    private static final String URL = "jdbc:mysql://localhost:3306/fortesting";
    private static final String USER = "root";
    private static final String PASSWORD = "physics.h123";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER); 
        return DriverManager.getConnection(URL, USER, PASSWORD); 
    }
}

package com.example.controller.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBC {
    private static String URL = "jdbc:mysql://localhost:3306/phone";
    private static String USER = "root";
    private static String PASSWORD = "1234";
    private static Connection connection;
    public static Connection getConnect(){

        if (connection==null){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(
                        URL,
                        USER,
                        PASSWORD
                );
                System.out.println("ket noi thanh cong");
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("ket noi khong thanh cong");
                e.printStackTrace();
            }
        }

        return  connection;
    }
}

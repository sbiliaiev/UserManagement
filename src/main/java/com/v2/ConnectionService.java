package com.v2;

import com.v2.repo.UserRepositoryImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionService {
    private static ConnectionService INSTANCE;

    private static Connection connection;

    final String url = "jdbc:postgresql://localhost:5432/UserManagement?ssl=false";

    private ConnectionService() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static ConnectionService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ConnectionService();
        }

        return INSTANCE;
    }

    public static Connection getConnection() {
        if (connection == null) {
            getInstance();
        }
        return connection;
    }


    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

package com.abc.dao;

import com.abc.models.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ServiceDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/ABC_Restaurant";
    private String jdbcUsername = "root";
    private String jdbcPassword = "your_password";

    private static final String INSERT_SERVICE_SQL = "INSERT INTO Services (service_name, description, price) VALUES (?, ?, ?);";

    public ServiceDAO() {}

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void saveService(Service service) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SERVICE_SQL)) {
            preparedStatement.setString(1, service.getServiceName());
            preparedStatement.setString(2, service.getDescription());
            preparedStatement.setDouble(3, service.getPrice());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

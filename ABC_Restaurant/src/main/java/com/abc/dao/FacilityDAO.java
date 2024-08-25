package com.abc.dao;

import com.abc.models.Facility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FacilityDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/ABC_Restaurant";
    private String jdbcUsername = "root";
    private String jdbcPassword = "your_password";

    private static final String INSERT_FACILITY_SQL = "INSERT INTO Facilities (facility_name, description) VALUES (?, ?);";

    public FacilityDAO() {}

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

    public void saveFacility(Facility facility) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_FACILITY_SQL)) {
            preparedStatement.setString(1, facility.getFacilityName());
            preparedStatement.setString(2, facility.getDescription());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

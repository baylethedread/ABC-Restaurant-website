package com.abc.dao;

import com.abc.models.Query;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class QueryDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/ABC_Restaurant";
    private String jdbcUsername = "root";
    private String jdbcPassword = "your_password";

    private static final String INSERT_QUERY_SQL = "INSERT INTO Queries (user_id, query_text, status) VALUES (?, ?, ?);";

    public QueryDAO() {}

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

    public void saveQuery(Query query) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY_SQL)) {
            preparedStatement.setInt(1, query.getUserId());
            preparedStatement.setString(2, query.getQueryText());
            preparedStatement.setString(3, query.getStatus());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

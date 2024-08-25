package com.abc.dao;

import com.abc.models.Reservation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReservationDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/ABC_Restaurant";
    private String jdbcUsername = "root";
    private String jdbcPassword = "your_password";

    private static final String INSERT_RESERVATION_SQL = "INSERT INTO Reservations (user_id, service_type, reservation_date, reservation_time, status) VALUES (?, ?, ?, ?, ?);";

    public ReservationDAO() {}

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

    public void saveReservation(Reservation reservation) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_RESERVATION_SQL)) {
            preparedStatement.setInt(1, reservation.getUserId());
            preparedStatement.setString(2, reservation.getServiceType());
            preparedStatement.setDate(3, reservation.getReservationDate());
            preparedStatement.setTime(4, reservation.getReservationTime());
            preparedStatement.setString(5, reservation.getStatus());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

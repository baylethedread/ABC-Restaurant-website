package com.abc.controllers;

import com.abc.dao.ReservationDAO;
import com.abc.models.Reservation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;

@WebServlet("/ReservationServlet")
public class ReservationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ReservationDAO reservationDAO;

    public ReservationServlet() {
        this.reservationDAO = new ReservationDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        String serviceType = request.getParameter("serviceType");
        Date reservationDate = Date.valueOf(request.getParameter("reservationDate"));
        Time reservationTime = Time.valueOf(request.getParameter("reservationTime"));

        Reservation reservation = new Reservation(0, userId, serviceType, reservationDate, reservationTime, "Pending");
        reservationDAO.saveReservation(reservation);

        response.sendRedirect("reservation.jsp");
    }
}

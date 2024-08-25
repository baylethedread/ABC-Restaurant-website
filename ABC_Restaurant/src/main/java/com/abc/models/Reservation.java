package com.abc.models;

import java.sql.Date;
import java.sql.Time;

public class Reservation {
    private int reservationId;
    private int userId;
    private String serviceType;
    private Date reservationDate;
    private Time reservationTime;
    private String status;

    public Reservation(int reservationId, int userId, String serviceType, Date reservationDate, Time reservationTime, String status) {
        this.reservationId = reservationId;
        this.userId = userId;
        this.serviceType = serviceType;
        this.reservationDate = reservationDate;
        this.reservationTime = reservationTime;
        this.status = status;
    }

    // Getters and Setters
    public int getReservationId() { return reservationId; }
    public void setReservationId(int reservationId) { this.reservationId = reservationId; }
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
    public String getServiceType() { return serviceType; }
    public void setServiceType(String serviceType) { this.serviceType = serviceType; }
    public Date getReservationDate() { return reservationDate; }
    public void setReservationDate(Date reservationDate) { this.reservationDate = reservationDate; }
    public Time getReservationTime() { return reservationTime; }
    public void setReservationTime(Time reservationTime) { this.reservationTime = reservationTime; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}

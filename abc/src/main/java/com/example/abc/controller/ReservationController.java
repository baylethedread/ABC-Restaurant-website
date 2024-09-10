package com.example.abc.controller;

import com.example.abc.model.Reservation;
import com.example.abc.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/reservation")
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;

    @GetMapping("/api/reservations")
    public List<Reservation> getReservations() {
        return reservationRepository.findAll();
    }

    @PostMapping("/confirm/{id}")
    public String confirmReservation(@PathVariable Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid reservation Id:" + id));
        reservation.setStatus("Confirmed");
        reservationRepository.save(reservation);
        return "redirect:/admin";
    }

    @PostMapping("/cancel/{id}")
    public String cancelReservation(@PathVariable Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid reservation Id:" + id));
        reservation.setStatus("Canceled");
        reservationRepository.save(reservation);
        return "redirect:/admin";
    }
}

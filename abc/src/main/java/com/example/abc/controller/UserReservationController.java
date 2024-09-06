package com.example.abc.controller;

import com.example.abc.model.Reservation;
import com.example.abc.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/reservations")
public class UserReservationController {

    @Autowired
    private ReservationRepository reservationRepository;

    @GetMapping
    public String viewReservations(Model model) {
        return "reservation";
    }

    @PostMapping("/add")
    public String addReservation(@RequestParam("customerName") String customerName,
                                 @RequestParam("date") String date,
                                 @RequestParam("time") String time,
                                 @RequestParam("query") String query) {

        Reservation reservation = new Reservation();
        reservation.setCustomerName(customerName);
        reservation.setDate(date);
        reservation.setTime(time);
        reservation.setQuery(query);
        reservation.setStatus("Pending"); // Default status

        reservationRepository.save(reservation);

        // Redirect back to the reservations page
        return "redirect:/reservations";
    }
}

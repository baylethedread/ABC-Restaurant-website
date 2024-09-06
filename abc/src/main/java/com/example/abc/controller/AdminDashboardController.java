package com.example.abc.controller;

import com.example.abc.model.Category;
import com.example.abc.model.Product;
import com.example.abc.model.Reservation;
import com.example.abc.repository.CategoryRepository;
import com.example.abc.repository.ProductRepository;
import com.example.abc.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin") // Ensure the base path is consistent
public class AdminDashboardController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ReservationRepository ReservationRepository;


    @GetMapping
    public String home(Model model) {
        List<Category> categories = categoryRepository.findAll();
        List<Product> products = productRepository.findAll();
        List<Reservation> Reservations = ReservationRepository.findAll();

        model.addAttribute("categories", categories);
        model.addAttribute("products", products);
        model.addAttribute("Reservations", Reservations);

        return "admin-dashboard"; // Thymeleaf template name
    }
}
